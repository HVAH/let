package com.vah.let.thread.completableFuture;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * @Description
 * @Author Jiang
 * @Date 2021/9/6 5:11 下午
 **/
@Service
public class AsyncScheduler implements AutoCloseable{

    @Async
    public CompletableFuture invoke(@NotNull Function0 task) {
        Intrinsics.checkNotNullParameter(task, "task");
        CompletableFuture future = CompletableFuture.completedFuture(task.invoke());
        Intrinsics.checkNotNullExpressionValue(future, "CompletableFuture.completedFuture(task())");
        return future;
    }


    @Override
    public void close() throws Exception {

    }
}

interface Function0 extends Function {
    Object invoke();
}
