import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class HockeyComparison{
  public static void main (String [] args) throws IOException {
    
    //Header
    System.out.println("**************************************************");
    System.out.println("Program description: Hockey Player Comparison");
    System.out.println("**************************************************");    
    
    //initializing scanners
    Scanner keyboard = new Scanner (System.in);
    
    //loads file that user inputs
    System.out.print("What is the name of the input file? ");
    String inputFileName = keyboard.nextLine();
    
    //selects two teams to compare
    System.out.print("Name of 1st team to be processed? ");
    String teamOneName = keyboard.nextLine();
    teamOneName = teamOneName.toUpperCase();
    
    System.out.print("Name of 2nd team to be processed? ");
    String teamTwoName = keyboard.nextLine();
    teamTwoName = teamTwoName.toUpperCase();
    
    //identifies file for use
    File inputFileBase = new File(inputFileName);
    //links file to scanner object
    Scanner inputFile = new Scanner(inputFileBase);
    //uses the "," as delimiter for scanner
    inputFile = inputFile.useDelimiter(",");
    
    //two arrays for holding all the players in each team chosen
    ArrayList<HockeyPlayer> teamOne = new ArrayList<HockeyPlayer>();
    ArrayList<HockeyPlayer> teamTwo = new ArrayList<HockeyPlayer>();
    
    //skips the header line
    inputFile.nextLine();
    
    while (inputFile.hasNextLine()){
      //order it is read from line :Player Name,Team,Pos,Games,G,A,Pts,+/-,PIM,SOG,GWG,PPG,PPA,SHG,SHA,Hits,BS
      //read player name
      String currentPlayerName = inputFile.next();
      //creating object with current player name
      HockeyPlayer currentPlayer = new HockeyPlayer(currentPlayerName);
      //read current players team
      String currentPlayerTeam = inputFile.next();
      // skip Pos
      inputFile.next();
      //read Games
      int games = inputFile.nextInt();
      currentPlayer.setGamesPlayed(games);   
      //read Goals
      int goals = inputFile.nextInt();
      currentPlayer.setGoals(goals);
      //read Assists
      int assists = inputFile.nextInt();
      currentPlayer.setAssists(assists);
      // skip pts
      inputFile.next();
      // skip +/-
      inputFile.next();
      // skip pim
      inputFile.next();
      // SOG- shots on goal
      int sog = inputFile.nextInt();
      currentPlayer.setShots(sog);
      
      //we find out if the player is on the needed team, then we put in corresponding array if they are.     
      if (currentPlayerTeam.equals(teamOneName)){
        teamOne.add(currentPlayer);
      } else if (currentPlayerTeam.equals(teamTwoName)){
        teamTwo.add(currentPlayer);
      }
      
      inputFile.nextLine();

    }
    
    
    System.out.println("Best Player");
    System.out.print(teamOneName + ": " + bestPlayer(teamOne));
    System.out.println();
    
    System.out.print(teamTwoName + ": " + bestPlayer(teamTwo));
    System.out.println();
    
    System.out.println("Best Player (PPG)");
    System.out.print(teamOneName + ": " + bestPlayerPPG(teamOne));
    System.out.println();
    
    System.out.print(teamTwoName + ": " + bestPlayerPPG(teamTwo));
    System.out.println();
    
    System.out.println("Best Shooter");
    System.out.print(teamOneName + ": " + bestShooter(teamOne));
    System.out.println();
    
    System.out.print(teamTwoName + ": " + bestShooter(teamTwo));
    System.out.println();
    
    //footer
    System.out.println("**************************************************");
    System.out.println("Program description: Hockey Player Comparison");
    System.out.println("**************************************************"); 
    inputFile.close();
  }
  
  // Name: bestPlayer
  // Purpose: This method will indicate who is the best player on the team as defined by total points. 
  // Arguments: players - an array list of all the players on a specific team 
  // Return: HockeyPlayer – the best player on the team as defined by points  
  public static HockeyPlayer bestPlayer(ArrayList<HockeyPlayer> players){
    //store first player as best player to have something to compare to
    HockeyPlayer best = players.get(0);
    //comparing all players, finding a better player until we check all
    for (int i = 0; i < players.size(); i++){
      HockeyPlayer player = players.get(i);
      if (player.getPoints() > best.getPoints()){
        best = player;
      }
    }
    return best;
  }
  
  // Name: bestPlayerPPG
  // Purpose: This method will indicate who is the best player on the team as defined by points per game (PPG). 
  // Arguments: players - an array list of all the players on a specific team 
  // Return: HockeyPlayer – the best player on the team as defined by points per game (PPG)
  public static HockeyPlayer bestPlayerPPG(ArrayList<HockeyPlayer> players){
    //store first player as best player
    HockeyPlayer best = players.get(0);
    //comparing to find one with highest points per game
    for (int i = 0; i < players.size(); i++){
      HockeyPlayer player = players.get(i);
      if (player.getPointsPerGame() > best.getPointsPerGame()){
        best = player;
      }
    }
    return best;
  }
  
  // Name: bestShooter
  // Purpose: This method will indicate who is the best shooter on the team as defined by shooting percentage. 
  // Arguments: players - an array list of all the players on a specific team 
  // Return: HockeyPlayer – the best player on the team as defined by shooting percentage
  public static HockeyPlayer bestShooter(ArrayList<HockeyPlayer> players){
    //store first player as best player
    HockeyPlayer best = players.get(0);
    //comparing to find one with highest shooting percentage
    for (int i = 0; i < players.size(); i++){
      HockeyPlayer player = players.get(i);
      if (player.getShootingPercentage() > best.getShootingPercentage()){
        best = player;
      }
    }
    return best;
  }
}