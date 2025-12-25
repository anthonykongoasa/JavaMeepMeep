import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class RedFar {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_OFFICIAL);




        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                //.setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(60,60,Math.toRadians(180), Math.toRadians(180), 16)


                .build();

        // Example trajectory
        myBot.runAction(
                myBot.getDrive().actionBuilder(new Pose2d(62,16,Math.toRadians(0)))

                        .lineToXLinearHeading(54, Math.toRadians(23))
                        //.waitSeconds(3)
                        //shoot here

                        //waitseconds
                        //placeholders

                        //shoot
                        .splineToLinearHeading(new Pose2d(35,25,Math.toRadians(92)), Math.toRadians(90))
                        .lineToY(50)


                        .splineToLinearHeading(new Pose2d(54,10,Math.toRadians(-23)), Math.toRadians(-23))
                        .lineToY(10)
                        //shoot, wait
                        .lineToX(50)
                        .splineToLinearHeading(new Pose2d( 42, 61, Math.toRadians(-360)), Math.toRadians(0))
                        //.lineToY(-59)

                        .lineToXConstantHeading(61)

                        //intake

                        .strafeToSplineHeading(new Vector2d(54, 10), Math.toRadians(-23))
                        //get off line
                        .lineToY(36)
                        .build()
        );


        meepMeep.addEntity(myBot);
        meepMeep.start();
    }
}
