import java.io.*;
import java.util.Scanner;

public class CensusPrinter
{
  public static void main(String [] args) throws IOException 
  {
    //Header
    System.out.println("**************************************************");
    System.out.println("Program description: Census Table Maker");
    System.out.println("**************************************************");
    
    //Initializing Variables to zero
    //<population totals>     <preschool kid totals>      <residential totals>        <hotel count totals>
    int northTotal = 0;      int northKidTotal = 0;      int northResTotal = 0;      int northHotelTotal = 0;
    int northeastTotal = 0;  int northeastKidTotal = 0;  int northeastResTotal = 0;  int northeastHotelTotal = 0; 
    int eastTotal = 0;       int eastKidTotal = 0;       int eastResTotal = 0;       int eastHotelTotal = 0; 
    int southeastTotal = 0;  int southeastKidTotal = 0;  int southeastResTotal = 0;  int southeastHotelTotal = 0; 
    int southTotal = 0;      int southKidTotal = 0;      int southResTotal = 0;      int southHotelTotal = 0;
    int southwestTotal = 0;  int southwestKidTotal = 0;  int southwestResTotal = 0;  int southwestHotelTotal = 0;
    int westTotal = 0;       int westKidTotal = 0;       int westResTotal = 0;       int westHotelTotal = 0;
    int northwestTotal = 0;  int northwestKidTotal = 0;  int northwestResTotal = 0;  int northwestHotelTotal = 0; 
    int centreTotal = 0;     int centreKidTotal = 0;     int centreResTotal = 0;     int centreHotelTotal = 0;
    
    // Create a Scanner object for keyboard input.
    Scanner keyboard = new Scanner(System.in);
    
    //Introduction screen  
    System.out.println("Welcome to Calgary Census 2018");
    System.out.println("-----------------------------------------------------------------");
    System.out.print("Input file: ");
    String inputFileName = keyboard.nextLine();
    System.out.print("Output file: ");
    String outputFileName = keyboard.nextLine();
    System.out.println("-----------------------------------------------------------------");
    System.out.println("File Processed: "+inputFileName);
    System.out.println("Results printed to: "+outputFileName);
    
    
    //identifies file for use
    File inputFileBase = new File(inputFileName);
    //links file to scanner object
    Scanner inputFile = new Scanner(inputFileBase);
    //identifies where and how to save result
    PrintWriter output =  new PrintWriter(outputFileName);
    
    //initializes grand totals
    //grand total of preschool kids
    int kidGrandTotal =  0;
    
    //grand total for residential
    int resGrandTotal =  0;
    
    //grand total for hotel
    int hotelGrandTotal = 0;
    
    //uses the tab as delimiter
    inputFile = inputFile.useDelimiter( "\\t" );
    //where each line stores the area the following columns reside in
    String sector;
    
    //skips first line of file
    inputFile.nextLine();
    
    
    //We are at the identifying sector information
    //Stores variables depending on identifying information in the row
    while (inputFile.hasNextLine()){
      inputFile.next();
      inputFile.next();
      inputFile.next();
      inputFile.next();
      sector = inputFile.next();
      
      
      if ("NORTH".equals(sector)){
        inputFile.next();
        inputFile.next();
        inputFile.next();
        inputFile.next();
        //Stores Res total
        northResTotal= northResTotal + inputFile.nextInt();
        //Stores preschool kid
        inputFile.next();
        northKidTotal= northKidTotal + inputFile.nextInt();
        //Stores hotel count
        for (int i = 0; i < 22 ; i++){
          inputFile.next();
        }
        northHotelTotal = northHotelTotal + inputFile.nextInt();
        
      }
      
      if ("NORTHEAST".equals(sector)){
        inputFile.next();
        inputFile.next();
        inputFile.next();
        inputFile.next();
        //Stores Res total
        northeastResTotal= northeastResTotal + inputFile.nextInt();
        //Stores preschool kid
        inputFile.next();
        northeastKidTotal= northeastKidTotal + inputFile.nextInt();
        //Stores hotel count
        for (int i = 0; i < 22 ; i++){
          inputFile.next();
        }
        northeastHotelTotal = northeastHotelTotal + inputFile.nextInt();
        
      }
      
      if ("EAST".equals(sector)){
        inputFile.next();
        inputFile.next();
        inputFile.next();
        inputFile.next();
        //Stores Res total
        eastResTotal= eastResTotal + inputFile.nextInt();
        //Stores preschool kid
        inputFile.next();
        eastKidTotal= eastKidTotal + inputFile.nextInt();
        //Stores hotel count
        for (int i = 0; i < 22 ; i++){
          inputFile.next();
        }
        eastHotelTotal = eastHotelTotal + inputFile.nextInt();
        
      }    
      
      if ("SOUTHEAST".equals(sector)){
        inputFile.next();
        inputFile.next();
        inputFile.next();
        inputFile.next();
        //Stores Res total
        southeastResTotal= southeastResTotal + inputFile.nextInt();
        //Stores preschool kid
        inputFile.next();
        southeastKidTotal= southeastKidTotal + inputFile.nextInt();
        //Stores hotel count
        for (int i = 0; i < 22 ; i++){
          inputFile.next();
        }
        southeastHotelTotal = southeastHotelTotal + inputFile.nextInt();
        
      }
      
      if ("SOUTH".equals(sector)){
        inputFile.next();
        inputFile.next();
        inputFile.next();
        inputFile.next();
        //Stores Res total
        southResTotal = southResTotal + inputFile.nextInt();
        //Stores preschool kid
        inputFile.next();
        southKidTotal= southKidTotal + inputFile.nextInt();
        //Stores hotel count
        for (int i = 0; i < 22 ; i++){
          inputFile.next();
        }
        southHotelTotal = southHotelTotal + inputFile.nextInt();
        
      }
      if ("SOUTHWEST".equals(sector)){
        inputFile.next();
        inputFile.next();
        inputFile.next();
        inputFile.next();
        //Stores Res total
        southwestResTotal = southwestResTotal + inputFile.nextInt();
        //Stores preschool kid
        inputFile.next();
        southwestKidTotal= southwestKidTotal + inputFile.nextInt();
        //Stores hotel count
        for (int i = 0; i < 22 ; i++){
          inputFile.next();
        }
        southwestHotelTotal = southwestHotelTotal + inputFile.nextInt();
        
      }
      if ("WEST".equals(sector)){
        inputFile.next();
        inputFile.next();
        inputFile.next();
        inputFile.next();
        //Stores Res total
        westResTotal= westResTotal + inputFile.nextInt();
        //Stores preschool kid
        inputFile.next();
        westKidTotal= westKidTotal + inputFile.nextInt();
        //Stores hotel count
        for (int i = 0; i < 22 ; i++){
          inputFile.next();
        }
        westHotelTotal = westHotelTotal + inputFile.nextInt();
        
      }
      
      if ("NORTHWEST".equals(sector)){
        inputFile.next();
        inputFile.next();
        inputFile.next();
        inputFile.next();
        //Stores Res total
        northwestResTotal= northwestResTotal + inputFile.nextInt();
        //Stores preschool kid
        inputFile.next();
        northwestKidTotal= northwestKidTotal + inputFile.nextInt();
        //Stores hotel count
        for (int i = 0; i < 22 ; i++){
          inputFile.next();
        }
        northwestHotelTotal = northwestHotelTotal + inputFile.nextInt();
        
      }
      if ("CENTRE".equals(sector)){
        inputFile.next();
        inputFile.next();
        inputFile.next();
        inputFile.next();
        //Stores Res total
        centreResTotal= centreResTotal + inputFile.nextInt();
        //Stores preschool kid
        inputFile.next();
        centreKidTotal= centreKidTotal + inputFile.nextInt();
        //Stores hotel count
        for (int i = 0; i < 22 ; i++){
          inputFile.next();
        }
        centreHotelTotal = centreHotelTotal + inputFile.nextInt();
        
      }
      inputFile.nextLine();
    }
    //grand total of preschool kids
    kidGrandTotal =   
      (northKidTotal + northeastKidTotal + eastKidTotal + southeastKidTotal + southKidTotal +
       southwestKidTotal + westKidTotal + northwestKidTotal + centreKidTotal);
    //grand total for residential
    resGrandTotal =   
      (northResTotal + northeastResTotal + eastResTotal + southeastResTotal + southResTotal + 
       southwestResTotal + westResTotal + northwestResTotal + centreResTotal);
    //grand total for hotel
    hotelGrandTotal =
      (northHotelTotal + northeastHotelTotal + eastHotelTotal + southeastHotelTotal + southHotelTotal + 
       southwestHotelTotal + westHotelTotal + northwestHotelTotal + centreHotelTotal);
    
    
    //Makes the output table with the proper filled in data
    output.printf("%34s%25s%19s","Preschool Kid","Residential Count","Hotel Count\n");
    output.printf("===================================================================================\n");
    output.printf("NORTH%29d%25d%19d\n",northKidTotal,northResTotal,northHotelTotal);
    output.printf("NORTHEAST%25d%25d%19d\n",northeastKidTotal,northeastResTotal,northeastHotelTotal);
    output.printf("EAST%30d%25d%19d\n",eastKidTotal,eastResTotal,eastHotelTotal);
    output.printf("SOUTHEAST%25d%25d%19d\n",southeastKidTotal,southeastResTotal,southeastHotelTotal);
    output.printf("SOUTH%29d%25d%19d\n",southKidTotal,southResTotal,southHotelTotal);
    output.printf("SOUTHWEST%25d%25d%19d\n",southwestKidTotal,southwestResTotal,southwestHotelTotal);
    output.printf("WEST%30d%25d%19d\n",westKidTotal,westResTotal,westHotelTotal);
    output.printf("NORTHWEST%25d%25d%19d\n",northwestKidTotal,northwestResTotal,northwestHotelTotal);
    output.printf("CENTRE%28d%25d%19d\n",centreKidTotal,centreResTotal,centreHotelTotal);
    output.printf("-----------------------------------------------------------------------------------\n");
    output.printf("Grand Total%23d%25d%19d\n",kidGrandTotal,resGrandTotal,hotelGrandTotal);
    output.printf("\n");
    
    //if statements that only activate if the total is higher than others  
    if (northResTotal > northeastResTotal && 
        northResTotal > eastResTotal      &&
        northResTotal > southeastResTotal &&
        northResTotal > southResTotal     &&
        northResTotal > southwestResTotal &&
        northResTotal > westResTotal      &&
        northResTotal > northwestResTotal &&
        northResTotal > centreResTotal){
      output.printf("Highest Population%16d%25s",northResTotal,"NORTH");}
    
    if (northeastResTotal > northResTotal && 
        northeastResTotal > eastResTotal &&
        northeastResTotal > southeastResTotal &&
        northeastResTotal > southResTotal &&
        northeastResTotal > southwestResTotal &&
        northeastResTotal > westResTotal &&
        northeastResTotal > northwestResTotal &&
        northeastResTotal > centreResTotal){
      output.printf("Highest Population%16d%25s",northeastResTotal,"NORTHEAST");}
    
    if (eastResTotal > northeastResTotal && 
        eastResTotal > northResTotal     &&
        eastResTotal > southeastResTotal &&
        eastResTotal > southResTotal     &&
        eastResTotal > southwestResTotal &&
        eastResTotal > westResTotal      &&
        eastResTotal > northwestResTotal &&
        eastResTotal > centreResTotal){
      output.printf("Highest Population%16d%25s",eastResTotal,"EAST");}
    
    if (southeastResTotal > northeastResTotal && 
        southeastResTotal > eastResTotal      &&
        southeastResTotal > northResTotal &&
        southeastResTotal > southResTotal     &&
        southeastResTotal > southwestResTotal &&
        southeastResTotal > westResTotal      &&
        southeastResTotal > northwestResTotal &&
        southeastResTotal > centreResTotal){
      output.printf("Highest Population%16d%25s",southeastResTotal,"SOUTHEAST");}
    
    if (southResTotal > northeastResTotal && 
        southResTotal > eastResTotal      &&
        southResTotal > southeastResTotal &&
        southResTotal > northResTotal     &&
        southResTotal > southwestResTotal &&
        southResTotal > westResTotal      &&
        southResTotal > northwestResTotal &&
        southResTotal > centreResTotal){
      output.printf("Highest Population%16d%25s",southResTotal,"SOUTH");}
    
    if (southwestResTotal > northeastResTotal && 
        southwestResTotal > eastResTotal      &&
        southwestResTotal > southeastResTotal &&
        southwestResTotal > southResTotal     &&
        southwestResTotal > northResTotal     &&
        southwestResTotal > westResTotal      &&
        southwestResTotal > northwestResTotal &&
        southwestResTotal > centreResTotal){
      output.printf("Highest Population%16d%25s",southwestResTotal,"SOUTHWEST");}
    
    if (westResTotal > northeastResTotal && 
        westResTotal > eastResTotal      &&
        westResTotal > southeastResTotal &&
        westResTotal > southResTotal     &&
        westResTotal > southwestResTotal &&
        westResTotal > northResTotal     &&
        westResTotal > northwestResTotal &&
        westResTotal > centreResTotal){
      output.printf("Highest Population%16d%25s",westResTotal,"WEST");}
    
    if (northwestResTotal > northeastResTotal && 
        northwestResTotal > eastResTotal      &&
        northwestResTotal > southeastResTotal &&
        northwestResTotal > southResTotal     &&
        northwestResTotal > southwestResTotal &&
        northwestResTotal > westResTotal      &&
        northwestResTotal > northResTotal     &&
        northwestResTotal > centreResTotal){
      output.printf("Highest Population%16d%25s",northwestResTotal,"NORTHWEST");}
    
    
    if (centreResTotal > northeastResTotal && 
        centreResTotal > eastResTotal      &&
        centreResTotal > southeastResTotal &&
        centreResTotal > southResTotal     &&
        centreResTotal > southwestResTotal &&
        centreResTotal > westResTotal      &&
        centreResTotal > northwestResTotal &&
        centreResTotal > northResTotal){
      output.printf("Highest Population%16d%25s",centreResTotal,"CENTRE");}
    
    //newline because I forgot to put on if statements for highest above      
    output.printf("\n");
    
    //if statements that only prints if the selected value is lowest    
    if (northResTotal < northeastResTotal && 
        northResTotal < eastResTotal      &&
        northResTotal < southeastResTotal &&
        northResTotal < southResTotal     &&
        northResTotal < southwestResTotal &&
        northResTotal < westResTotal      &&
        northResTotal < northwestResTotal &&
        northResTotal < centreResTotal){
      output.printf("Lowest Population%17d%25s",northResTotal + "NORTH");}
    
    if (northeastResTotal < northResTotal && 
        northeastResTotal < eastResTotal &&
        northeastResTotal < southeastResTotal &&
        northeastResTotal < southResTotal &&
        northeastResTotal < southwestResTotal &&
        northeastResTotal < westResTotal &&
        northeastResTotal < northwestResTotal &&
        northeastResTotal < centreResTotal){
      output.printf("Lowest Population%17d%25s",northeastResTotal,"NORTHEAST");}
    
    if (eastResTotal < northeastResTotal && 
        eastResTotal < northResTotal     &&
        eastResTotal < southeastResTotal &&
        eastResTotal < southResTotal     &&
        eastResTotal < southwestResTotal &&
        eastResTotal < westResTotal      &&
        eastResTotal < northwestResTotal &&
        eastResTotal < centreResTotal){
      output.printf("Lowest Population%17d%25s",eastResTotal,"EAST");}
    
    if (southeastResTotal < northeastResTotal && 
        southeastResTotal < eastResTotal      &&
        southeastResTotal < northResTotal &&
        southeastResTotal < southResTotal     &&
        southeastResTotal < southwestResTotal &&
        southeastResTotal < westResTotal      &&
        southeastResTotal < northwestResTotal &&
        southeastResTotal < centreResTotal){
      output.printf("Lowest Population%17d%25s",southeastResTotal,"SOUTHEAST");}
    
    if (southResTotal < northeastResTotal && 
        southResTotal < eastResTotal      &&
        southResTotal < southeastResTotal &&
        southResTotal < northResTotal     &&
        southResTotal < southwestResTotal &&
        southResTotal < westResTotal      &&
        southResTotal < northwestResTotal &&
        southResTotal < centreResTotal){
      output.printf("Lowest Population%17d%25s",southResTotal,"SOUTH");}
    
    if (southwestResTotal < northeastResTotal && 
        southwestResTotal < eastResTotal      &&
        southwestResTotal < southeastResTotal &&
        southwestResTotal < southResTotal     &&
        southwestResTotal < northResTotal     &&
        southwestResTotal < westResTotal      &&
        southwestResTotal < northwestResTotal &&
        southwestResTotal < centreResTotal){
      output.printf("Lowest Population%17d%25s",southwestResTotal,"SOUTHWEST");}
    
    if (westResTotal < northeastResTotal && 
        westResTotal < eastResTotal      &&
        westResTotal < southeastResTotal &&
        westResTotal < southResTotal     &&
        westResTotal < southwestResTotal &&
        westResTotal < northResTotal     &&
        westResTotal < northwestResTotal &&
        westResTotal < centreResTotal){
      output.printf("Lowest Population%17d%25s",westResTotal,"WEST");}
    
    if (northwestResTotal < northeastResTotal && 
        northwestResTotal < eastResTotal      &&
        northwestResTotal < southeastResTotal &&
        northwestResTotal < southResTotal     &&
        northwestResTotal < southwestResTotal &&
        northwestResTotal < westResTotal      &&
        northwestResTotal < northResTotal     &&
        northwestResTotal < centreResTotal){
      output.printf("Lowest Population%17d%25s",northwestResTotal,"NORTHWEST");}
    
    if (centreResTotal < northeastResTotal && 
        centreResTotal < eastResTotal      &&
        centreResTotal < southeastResTotal &&
        centreResTotal < southResTotal     &&
        centreResTotal < southwestResTotal &&
        centreResTotal < westResTotal      &&
        centreResTotal < northwestResTotal &&
        centreResTotal < northResTotal){
      output.printf("Lowest Population%17d%25s",centreResTotal,"CENTRE");}
    
    //newline because I forgot to put on if statements for highest above    
    output.printf("\n");
    
    //last part of intro screen, has to be here to properly have totals
    System.out.printf("\n");
    System.out.printf("Summary:\n");
    System.out.printf("Total Residential population:%12d",resGrandTotal);
    System.out.printf("\n");
    //Footer
    System.out.println("**************************************************");
    System.out.println("Program description: Census Table Maker");
    System.out.println("**************************************************");
    //closes inputfile scanner
    inputFile.close();
    //closes writer
    output.close();
  }
}