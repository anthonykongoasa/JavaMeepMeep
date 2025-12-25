import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;

import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;





// 9 artifact auto!!
public class RedClose {



    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_OFFICIAL);




        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)

                .setConstraints(60,60,Math.toRadians(180), Math.toRadians(180), 16)

                .build();


        myBot.runAction(
                myBot.getDrive().actionBuilder(new Pose2d(-61,38, Math.toRadians(-180)))


                        .lineToX(-52)
                        .splineToLinearHeading(new Pose2d(-23, 23, Math.toRadians(-45)), Math.toRadians(-90))
                        .splineToLinearHeading(new Pose2d(-12, 32, Math.toRadians(90)), Math.toRadians(90))
                        .lineToY(52)
                        .strafeToLinearHeading(new Vector2d(-23,23), Math.toRadians(-45))
                        .splineToLinearHeading(new Pose2d(11, 32,Math.toRadians(90)), Math.toRadians(90))
                        .lineToY(52)
                        .strafeToLinearHeading(new Vector2d(-23,23), Math.toRadians(-45))
                        // off line
                        .lineToY(32)
                        .build()

        );

        meepMeep.addEntity(myBot);
        meepMeep.start();
    }
}


