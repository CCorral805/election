import java.util.Scanner;
public class Election{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Fall 2024 - CS1083 - Section 003 - Project 1 - Election - written by Carlos Corral");
    
    System.out.print("Please, input the initial percent: ");
    double initial = sc.nextDouble();
    System.out.print("Please, input the daily percent increase: ");
    double daily = sc.nextDouble();
    System.out.print("Please, input the weekend percent increase: ");
    double weekend = sc.nextDouble();
    System.out.print("First day of the month(0-Mon, 1-Tue, 2-Wed, 3-Thur, 4-Fri, 5-Sat, 6-Sun): ");
    int negDays = sc.nextInt();
    char month;
    do {
      System.out.print("Last day of the month (A-28, B-30, C-31): ");
      month = sc.next().charAt(0);
    } while (month != 'A' && month != 'B' && month != 'C');
    
    System.out.print("Please, input the percent that increases when there is a rally in the state: ");
    double rallyInc = sc.nextDouble();
    System.out.print("First rally (day of the month): ");
    int rally1=sc.nextInt();
    System.out.print("Second rally (day of the month): ");
    int rally2=sc.nextInt();
    System.out.print("Third rally (day of the month): ");
    int rally3=sc.nextInt();

    int monthDays=0;
    switch (month) {
      case 'A':
        monthDays = 28;
        break;
      case 'B':
        monthDays = 30;
        break;
      case 'C':
        monthDays = 31;
        break;

    }

    System.out.println("Week\tMonday\tTuesday\tWednesday\tThursday\tFriday\tSaturday\tSunday\tTotal/Week");
    int week = 1;
    int day = 1-negDays;
    for (; week<=6 ; week++ ){                                                                                              //iterate per week
      double weekSum=0;
      if(day>monthDays){break;}
      System.out.printf("%d\t",week);                                                                                            //iterate per day in range (1,monthDays)
        for (int i = 1 ; i<=7 ; i++){
          double rallyExtra = 0;
          if(day==rally1||day==rally2||day==rally3){
            rallyExtra = rallyInc;
          }
          if(day<=0||day>monthDays) {       //Have not started month or month already ended
              System.out.printf("0-0.000\t");;
              day++;
          } else if(day==1){                //First day
              System.out.printf("%d-%.3f\t",day,initial+rallyExtra);
              weekSum+=initial+rallyExtra;
              day++;
          } else if(i==6||i==7){    //Weekends
              System.out.printf("%d-%.3f\t",day,weekend+rallyExtra);
              weekSum+=weekend+rallyExtra;
              day++;  
          } else {                  //regular days
              System.out.printf("%d-%.3f\t",day,daily+rallyExtra);
              weekSum+=daily+rallyExtra;
              day++;
          }
      }
      System.out.printf("W-%d-%.3f\n",week,weekSum);


    }

  }
}
