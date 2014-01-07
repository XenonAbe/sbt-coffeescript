package com.typesafe.coffeescript;

import akka.actor.{ActorRefFactory, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.typesafe.jse.Engine.{ExecuteJs, JsExecutionResult}
import java.util.concurrent.TimeUnit
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, FiniteDuration}

/**
 * Abstracts the details of how JavaScript execution actually happens.
 */
trait JsExecutor {
  def executeJs(args: ExecuteJs): Future[JsExecutionResult]
  final def executeJsSync(args: ExecuteJs): JsExecutionResult = {
    Await.result(executeJs(args), Duration.Inf)
  }
}

/**
 * Executes JavaScript using the JS engine's actor-based system.
 */
class DefaultJsExecutor(engineProps: Props, actorRefFactory: ActorRefFactory, implicit val timeout: Timeout = DefaultJsExecutor.reallyLongTimeout) extends JsExecutor {
  def executeJs(args: ExecuteJs): Future[JsExecutionResult] = {
    val engine = actorRefFactory.actorOf(engineProps) // TODO: Give engine actor a name; unfortunately the engine doesn't give a unique context so clashes are possible
    (engine ? args).mapTo[JsExecutionResult]
  }
}

object DefaultJsExecutor {
  /**
   * A timeout a long way in the future. We don't want to timeout since we can't
   * really do anything sensible to recover. Instead the user or CI tool can cancel
   * the build at a higher level if they think there's a problem.
   */
  private val reallyLongTimeout = Timeout(FiniteDuration(100, TimeUnit.DAYS))

}