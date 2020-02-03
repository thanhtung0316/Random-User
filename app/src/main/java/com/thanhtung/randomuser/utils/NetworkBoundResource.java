package com.thanhtung.randomuser.utils;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.thanhtung.randomuser.request.ApiResponse;

public abstract class NetworkBoundResource<C,R> {
    private AppExecutors appExecutors;
    private MediatorLiveData<Resource<C>> results = new MediatorLiveData<>();

    public NetworkBoundResource(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
        init();
    }

    private void init() {
        results.setValue((Resource<C>) Resource.loading(null));
        final LiveData<C> dbSource = loadFromDb();
        results.addSource(dbSource, new Observer<C>() {
            @Override
            public void onChanged(C c) {
                if (shouldFetch(c)){
                    fetchFromNetwork(dbSource);
                }
            }
        });
    }

    private void fetchFromNetwork(final LiveData<C> dbSource) {
        results.addSource(dbSource, new Observer<C>() {
            @Override
            public void onChanged(C c) {
                setValue(Resource.loading(c));
            }
        });
        final LiveData<ApiResponse<R>> apiResponse = createCall();

        results.addSource(apiResponse, new Observer<ApiResponse<R>>() {
            @Override
            public void onChanged(final ApiResponse<R> rApiResponse) {
                results.removeSource(dbSource);
                results.removeSource(apiResponse);

                if (rApiResponse instanceof ApiResponse.ApiSuccessResponse){
                    appExecutors.getDiskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            saveCallResult((R) processResponse((ApiResponse.ApiSuccessResponse) rApiResponse));
                            appExecutors.getMainThreadExecutor().execute(new Runnable() {
                                @Override
                                public void run() {
                                    results.addSource(loadFromDb(), new Observer<C>() {
                                        @Override
                                        public void onChanged(C c) {
                                            setValue(Resource.success(c));
                                        }
                                    });
                                }
                            });

                        }
                    });
                } else if (rApiResponse instanceof ApiResponse.ApiEmptyResponse){
                    appExecutors.getMainThreadExecutor().execute(new Runnable() {
                        @Override
                        public void run() {
                            results.addSource(loadFromDb(), new Observer<C>() {
                                @Override
                                public void onChanged(C c) {
                                    setValue(Resource.success(c));
                                }
                            });
                        }
                    });
                } else if (rApiResponse instanceof ApiResponse.ApiErrorResponse){
                    results.addSource(dbSource, new Observer<C>() {
                        @Override
                        public void onChanged(C c) {
                           setValue(Resource.error(c,((ApiResponse.ApiErrorResponse) rApiResponse).getErrorMessage()));
                        }
                    });
                }


            }
        });
    }

    private C processResponse(ApiResponse.ApiSuccessResponse response){
        return (C) response.getBody();
    }

    protected abstract void saveCallResult(R item);


    protected abstract LiveData<ApiResponse<R>> createCall();

    private void setValue(Resource<C> newValue) {
        if (results.getValue()!=newValue){
            results.setValue(newValue);
        }
    }

    protected abstract boolean shouldFetch(C c);

    protected abstract LiveData<C> loadFromDb();

    public final LiveData<Resource<C>> getAsLiveData(){
        return results;
    }
}
