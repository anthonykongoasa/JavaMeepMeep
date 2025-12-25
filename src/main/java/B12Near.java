import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import java.awt.geom.AffineTransform;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;


public class B12Near {

// 12 artifact auto/ open



    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_OFFICIAL);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60,50,Math.toRadians(180), Math.toRadians(180), 10)
                .build();

        Vector2d shootPos = new Vector2d(-16, -20);


        myBot.runAction(
                myBot.getDrive().actionBuilder(new Pose2d(-54,-46, Math.toRadians(55)))

                        // ------------Shoot -----

                        .strafeToLinearHeading(shootPos, Math.toRadians(45), new TranslationalVelConstraint(70))
                        .waitSeconds(1.5) // we'll take this out + replace w/ shooting stuff
                        //shoot();
                        // ----------------------------Intake 1st pile --------
                        //intake.setPower(-1);
                        .strafeToLinearHeading(new Vector2d(-12, -26), Math.toRadians(-90), new TranslationalVelConstraint(15))
                        .strafeToLinearHeading(new Vector2d(-12, -48), Math.toRadians(-90), new TranslationalVelConstraint(50))

                       //----------------gate-------
                       
                        .strafeToLinearHeading(new Vector2d(-6, -48), Math.toRadians(180))
                        .strafeToConstantHeading(new Vector2d(-6, -52), new TranslationalVelConstraint(65))
                        .waitSeconds(0.5)
                        //--------------shoot------------
                        .strafeToLinearHeading(shootPos, Math.toRadians(45), new TranslationalVelConstraint(65))

                        .waitSeconds(1.5)
                        // ----------------------------Intake 2nd pile --------
                        .splineTo(new Vector2d(11.5, -26), Math.toRadians(-90), new TranslationalVelConstraint(60))
                        .splineTo(new Vector2d(11.5, -48), Math.toRadians(-90), new TranslationalVelConstraint(25))



                        .strafeToLinearHeading(shootPos, Math.toRadians(45), new TranslationalVelConstraint(65))
                        .waitSeconds(1.5) // we'll take this out + replace w/ shooting stuff
                        //--------------pile #3

                        .splineTo(new Vector2d(35, -26), Math.toRadians(-90), new TranslationalVelConstraint(60))
                        .splineTo(new Vector2d(35, -52), Math.toRadians(-90),  new TranslationalVelConstraint(25))

                        .waitSeconds(0.3)
                        .strafeToLinearHeading(new Vector2d(55, -13), Math.toRadians(25), new TranslationalVelConstraint(40))
                        .waitSeconds(1.5) // we'll take this out + replace w/ shooting stuff
                        //splineTo(new Vector2d(-6, -48), Math.toRadians(180))

                        //rotate heading for  setup for Teleop
                        .strafeToLinearHeading(new Vector2d(0, -45), Math.toRadians(90))



                        .build()
        );

        meepMeep.addEntity(myBot);
        meepMeep.start();
    }
}



