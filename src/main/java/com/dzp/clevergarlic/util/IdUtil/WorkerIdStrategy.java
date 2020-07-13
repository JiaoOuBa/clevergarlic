package com.dzp.clevergarlic.util.IdUtil;

public interface WorkerIdStrategy {
    void initialize();

    long availableWorkerId();

    void release();
}
