package TicTocToe.Models;

import TicTocToe.Factory.BotPlayingStrategyFactory;
import TicTocToe.Strategies.BotPlayingStrategies.BotPlayingStrategies;

public class Bot extends Player{
    private PlyerDifficultyLevel playerDifficultyLevel;
    private BotPlayingStrategies botPlayingStrategies;

    public BotPlayingStrategies getBotPlayingStrategies() {
        return botPlayingStrategies;
    }
    public void setBotPlayingStrategies(BotPlayingStrategies botPlayingStrategies) {
        this.botPlayingStrategies = botPlayingStrategies;
    }
    public PlyerDifficultyLevel getPlayerDifficultyLevel() {
        return playerDifficultyLevel;
    }

    public void setPlayerDifficultyLevel(PlyerDifficultyLevel playerDifficultyLevel) {
        this.playerDifficultyLevel = playerDifficultyLevel;
    }


    public Bot(String Name,char Symbol, PlyerDifficultyLevel playerDifficultyLevel){
        super(Name,Symbol);
        this.setPlayerDifficultyLevel(playerDifficultyLevel);
        this.botPlayingStrategies= BotPlayingStrategyFactory.getBotPlayingStrategiesforEnum(playerDifficultyLevel);
    }
    public Move decideNextMove(Board board){
    return botPlayingStrategies.decideNextMove(this,board);
    }
}
