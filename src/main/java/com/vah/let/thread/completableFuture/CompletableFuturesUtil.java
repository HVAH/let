// CompletableFuturesKt.java
package com.vah.let.thread.completableFuture;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CompletableFuturesUtil {

   public static void main(String[] args) {
      CompletableFuturesUtil.async(new Function0() {
         @Override
         public Object invoke() {
            return null;
         }

         @Override
         public Object apply(Object o) {
            return null;
         }
      });
   }

   @NotNull
   private static AsyncScheduler springAsync = new AsyncScheduler() {

      private final ThreadPoolExecutor executor;

      {
         int availableProcessors = Runtime.getRuntime().availableProcessors();
         executor = new ThreadPoolExecutor(
                 availableProcessors,
                 availableProcessors << 3,
                 20,
                 TimeUnit.SECONDS,
                 new LinkedBlockingQueue<>(100000)
         );
      }

      @Override
      @NotNull
      public CompletableFuture invoke(@NotNull Function0 task) {
         return CompletableFuture.supplyAsync((new CompletableFs(task)), executor);
      }

      @Override
      public void close() throws InterruptedException {
         executor.shutdown();
         executor.awaitTermination(20L, TimeUnit.SECONDS);
      }
   };

   @NotNull
   public static final AsyncScheduler getSpringAsync() {
      return springAsync;
   }

   public static final void setSpringAsync(@NotNull AsyncScheduler scheduler) {
      springAsync = scheduler;
   }

   @NotNull
   public static final CompletableFuture async(@NotNull Function0 supply) {
      return springAsync.invoke(supply);
   }

   public static final Object await(@NotNull CompletableFuture future) throws Throwable {

      try {
         return future.join();
      } catch (CompletionException exception) {
         throw unwrapThrowable(exception);
      }
   }

   @Nullable
   public static final Object awaitOrNull(@NotNull CompletableFuture $this$awaitOrNull) {
      Intrinsics.checkNotNullParameter($this$awaitOrNull, "$this$awaitOrNull");

      Object var1;
      try {
         var1 = $this$awaitOrNull.join();
      } catch (Exception var3) {
         var1 = null;
      }

      return var1;
   }

   @NotNull
   public static final CompletableFuture catchApply(@NotNull CompletableFuture future, @NotNull final Function1 supply) {
      CompletableFuture futureReturn = future.exceptionally(new Function() {
         @Override
         public Object apply(Object obj) {
            return this.apply((Throwable)obj);
         }

         public final Object apply(Throwable it) {
            return supply.invoke(CompletableFuturesUtil.unwrapThrowable(it));
         }
      });
      return futureReturn;
   }

   private static final Throwable unwrapThrowable(Throwable it) {
      Throwable e = it;
      while (e instanceof CompletionException || e instanceof  UndeclaredThrowableException || e instanceof ExecutionException) {
         if (e == null) {
            return e;
         }
         e = e.getCause();
      }
      return e;
   }
}
final class CompletableFs implements Supplier {
   private final Function0 function;

   CompletableFs(Function0 function0) {
      this.function = function0;
   }

   @Override
   public final Object get() {
      return this.function.invoke();
   }
}

interface Function1 extends Function {
   Object invoke(Object obj);
}
