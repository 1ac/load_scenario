package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class NginxHome extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080")

  val scn = scenario("home")
    .exec(http("home")
      .get("/"))

  setUp(
    scn.inject(
//      constantUsersPerSec(1).during(60),
//      nothingFor(4), // 1
      constantConcurrentUsers(10).during(60), // 1
//      rampUsers(10).during(5), // 3
//      constantUsersPerSec(1).during(60) // 4
//      constantUsersPerSec(20).during(15).randomized(), // 5
//      rampUsersPerSec(10).to(20).during(10), // 6
//      rampUsersPerSec(10).to(20).during(10).randomized(), // 7
//      stressPeakUsers(1000).during(20) // 8
    ).protocols(httpProtocol)
  );

  //setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))

}
