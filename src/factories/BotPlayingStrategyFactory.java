package factories;

import models.BotDifficultyLevel;
import strategies.botplayingstrategy.BotPlayingStrategy;
import strategies.botplayingstrategy.EasyBotPlayingStrategy;
import strategies.botplayingstrategy.HardBotPlayingStrategy;
import strategies.botplayingstrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        switch (botDifficultyLevel) {
            case MEDIUM -> {
                return new MediumBotPlayingStrategy();
            }
            case HARD -> {
                return new HardBotPlayingStrategy();
            }
            default -> {
                return new EasyBotPlayingStrategy();
            }
        }
    }
}
