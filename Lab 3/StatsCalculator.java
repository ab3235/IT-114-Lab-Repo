
public class StatsCalculator {

    public static void main(String[] args) {
        //  1. 2D array with the sample data /////////////////////////////////////////////////////////////////////////
        double[][] scores = {
            {85.5, 90.0, 78.5, 92.0},
            {76.0, 88.5, 90.0, 85.0},
            {95.0, 92.0, 94.5, 98.0},
            {60.0, 70.5, 65.0, 72.0},
            {82.0, 84.0, 80.0, 88.0}
        };

        // 2. Call methods /////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("--- GradeBook Statistics ---\n");
        calculateStudentAverages(scores);

        System.out.println();
        calculateAssignmentAverages(scores);

        System.out.println();
        findHighestScore(scores);
    }

    // Implemented this method /////////////////////////////////////////////////////////////////////////////////////
    public static void calculateStudentAverages(double[][] data) {
        System.out.println("Student Averages:");

        // logic implementation ////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < data.length; i++) {
            double sum = 0;

            for (int j = 0; j < data[i].length; j++) {
                sum = sum + data[i][j];
            }
            double average = sum / data[i].length;

            // print F output //////////////////////////////////////////////////////////////////////////////////////////
            System.out.printf("Student %d: %.2f\n", i + 1, average);
        }
    }

    // TODO: Implement this method /////////////////////////////////////////////////////////////////////////////////
    public static void calculateAssignmentAverages(double[][] data) {
        System.out.println("Assignment Averages:");

        //logic ////////////////////////////////////////////////////////////////////////////////////////////////////
        int assignments = data[0].length;

        for (int j = 0; j < assignments; j++) {
            double sum = 0;

            for (int i = 0; i < data.length; i++) {
                sum = sum + data[i][j];
            }
            double average = sum / data.length;
            System.out.print("Assignment " + (j + 1) + ": ");
            System.out.printf("%.2f\n", average);
        }
    }

    public static void findHighestScore(double[][] data) {
        // Your logic here
        double highscore = data[0][0];
        int students = 0;
        int assignment = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > highscore) {
                    highscore = data[i][j];
                    students = i;
                    assignment = j;
                }
            }
        }

        System.out.print("Highest Score in Class: ");
        System.out.printf("%.2f", highscore);
        System.out.print(" (Student " + (students + 1) + ", Assignment " + (assignment + 1) + ")");
        System.out.println();
    }


/// Extra credit wooooooo ///////////////////////////////////////////////////////////////////////////////////////////////////////////           ----------- I DID NOT COMPLETE THIS SECTION -------------------------------------
   // public static void calculateWeightedAverages(double[][] data) { 
        
        
// array to store Weights ////////////////////////////////////////////////////////////////////////////////////////////////////////////
         //double[] weights = {0.40, 0.30, 0.20, 0.10};
        
        
// implementation to other array so it works ///////////////////////////////////
        }
