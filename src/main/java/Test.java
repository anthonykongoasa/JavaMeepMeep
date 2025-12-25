import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class test {
    public static void main(String [] args) {
MeepMeep meepMeep = new MeepMeep(800);



RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
        .setColorScheme(new ColorSchemeBlueDark())
        .setConstraints(60,60,Math.toRadians(180), Math.toRadians(180), 16)
        .build();

 myBot.runAction(
         myBot.getDrive().actionBuilder(new Pose2d(0,0,Math.toRadians(0)))


            .strafeToSplineHeading(new Vector2d(40, 55), Math.toRadians(90))
                // .strafeToLinearHeading(new Vector2d(40,55), Math.toRadians(-180))
                 .strafeToLinearHeading(new Vector2d(55, 55), Math.toRadians(-180))
                 .splineToSplineHeading(new Pose2d( 34, 55, Math.toRadians(90)), Math.toRadians(180))
                 .splineToLinearHeading(new Pose2d(10, 55, Math.toRadians(90)), 0)
                 .strafeToLinearHeading(new Vector2d(10, 50), Math.toRadians(90))
                 .splineToLinearHeading(new Pose2d(10, 40, Math.toRadians(90)), Math.toRadians(90))
                 .splineToLinearHeading(new Pose2d(10, 20, Math.toRadians(90)), Math.toRadians(90))
                 //.splineToLinearHeading(new Pose2d(10, 10, Math.toRadians(90)), Math.toRadians(-180))

                // .splineTo(new Vector2d(40, 55), Math.toRadians(-180))


            .build());

  meepMeep.addEntity(myBot);
  meepMeep.start();
  }

}
