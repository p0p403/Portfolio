public class HockeyPlayer{
  
  private String _name;
  private int _goals;
  private int _assists;
  private int _gamesPlayed;
  private int _shots;
  
  public HockeyPlayer(){
    _name = "";
    _goals = -1;
    _assists = -1;
    _gamesPlayed =-1;
    _shots = -1;
  }
  
  public HockeyPlayer(String name){
    _name = name;
    _goals = -1;
    _assists = -1;
    _gamesPlayed =-1;
    _shots = -1;
  }
  
  public void setName(String name){
    _name = name;
  }
  
  public String getName(){
    return _name;
  }
  
  public void setGoals(int goals){
    _goals = goals;
  }
  
  public int getGoals(){
    return _goals;
  }
  
  public void setAssists(int assists){
    _assists = assists;
  }
  
  public int getAssists(){
    return _assists;
  }
  
  public void setGamesPlayed(int games){
    _gamesPlayed = games;
  }
  
  public int getGamesPlayed(){
    return _gamesPlayed;
  }
  
  public void setShots(int shots){
    _shots = shots;
  }
  
  public int getShots(){
    return _shots;
  }
  
  //gets the assists and goals , adds them and returns points  
  public int getPoints(){
    int points = getAssists() + getGoals();  
    return points;
  }   
  
  //calculates points per game by dividing players points, by games played
  public double getPointsPerGame(){
    //we cannot divide by zero, it would make the value infinity in output, not all players play every season
    if (getGamesPlayed() == 0){
      return 0.0;
    }
    double ppg = (double)getPoints() / (double)getGamesPlayed();
    return ppg;
  }
  
  public double getShootingPercentage(){
    //we cannot divide by zero, it would make the value infinity in output, not all players shoot (goalies,defence)
    if (getShots() == 0){
      return 0.0;
    }
    double st =  (double)getGoals() / (double)getShots();
    return st*100.0;
  }
  
  //prints players statistics as per requirements
  public String toString(){
    String firstLine = String.format("Name: %s\n",getName());
    String secondLine = String.format("%5s%5s%5s%5s%7s%5s%7s\n","GP","G","A","PTS","PPG","S","ST%");
    String thirdLine = String.format("%5s%5s%5s%5s%7.2f%5s%7.2f\n",getGamesPlayed(),getGoals(),getAssists(),
                                       getPoints(),getPointsPerGame(),getShots(),getShootingPercentage()); 
    
    return firstLine + secondLine + thirdLine;
  }
}