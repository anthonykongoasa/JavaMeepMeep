import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import java.awt.geom.AffineTransform;
/**
 * public void shoot() {
 *     intake.setPower(-1);
 *     leftUptake.setPower(-1);   // CR servos
 *     rightUptake.setPower(1);
 *     leftHand.setPower(-1);
 *     rightHand.setPower(1);
 *     delay(3.0); // wait 3 seconds
 *
 *     // stop
 *     intake.setPower(0);
 *     leftUptake.setPower(0);
 *     rightUptake.setPower(0);
 *     leftHand.setPower(0);
 *     rightHand.setPower(0);
 * }
 */

public class BlueNOpen {

// 6 artifact auto/ open
// 9-10ish seconds total
// Maybe for speed purposes - 3 shot, empty, wait,


    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_OFFICIAL);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60,60,Math.toRadians(180), Math.toRadians(180), 10)
                .build();

        Vector2d shootPos = new Vector2d(-34, -34);


        myBot.runAction(
                myBot.getDrive().actionBuilder(new Pose2d(-61,-40, Math.toRadians(0)))

                        // ------------Shoot ------
                        .strafeToLinearHeading(shootPos, Math.toRadians(45))
                        .waitSeconds(2.75) // we'll take this out + replace w/ shooting stuff
                        //shoot();
                        // ----------------------------Intake 1st pile --------
                        //intake.setPower(-1);
                        .splineToLinearHeading(new Pose2d(-12, -30, Math.toRadians(-90)), Math.toRadians(0))
                        .strafeToLinearHeading(new Vector2d(-12, -48), Math.toRadians(-90))
                        //--------------shoot------------
                        .strafeToSplineHeading(shootPos, Math.toRadians(45))
                        //shoot
                        .waitSeconds(2.75)
                        // ----------------------------Intake 1st pile --------
                        .strafeToLinearHeading(new Vector2d(11.5, -30), Math.toRadians(-90))
                        .strafeToLinearHeading(new Vector2d(11.5, -48), Math.toRadians(-90))

                        //--------------Open Gate----
                        .strafeToLinearHeading(new Vector2d(0, -53), Math.toRadians(0))
                        .waitSeconds(1.5)

                        //--------------final shoot position, off line-----------
                        .strafeToSplineHeading(new Vector2d(-50, -20), Math.toRadians(75))
                        .waitSeconds(10) // partner score sorted

                        //rotate heading for to setup for Teleop
                        .strafeToLinearHeading(new Vector2d(-50, -25), Math.toRadians(-90))
                        .build()
        );

        meepMeep.addEntity(myBot);
        meepMeep.start();
    }
}


