package TicTocToe.Factory;

import TicTocToe.Models.PlyerDifficultyLevel;
import TicTocToe.Strategies.BotPlayingStrategies.BotPlayingStrategies;
import TicTocToe.Strategies.BotPlayingStrategies.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategies getBotPlayingStrategiesforEnum(PlyerDifficultyLevel plyerDifficultyLevel) {
        return new RandomBotPlayingStrategy();
    }

}
