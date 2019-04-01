


public class Soduku {
    private boolean[][] rowFilled = new boolean[5][5];
    private boolean[][] colFilled = new boolean[5][5];
    private boolean[] line1Filled = new boolean[5];
    private boolean[] line2Filled = new boolean[5];
    private int[][] datas = new int[5][5];
    private int fillCount = 0;
 
    public static void main(String[] args) throws Exception {
        new Soduku().fill(0, 0);
    }
 
    private void fill(int row, int col) {
        for(int i = 0; i < 5; i++) {
            if(!rowFilled[row][i] && !colFilled[col][i] && (row != col || !line1Filled[i]) && (row + col != 6 || !line2Filled[i])) {
                rowFilled[row][i] = true;
                colFilled[col][i] = true;
                if(row == col)
                    line1Filled[i] = true;
                if(row + col == 6)
                    line2Filled[i] = true;
                datas[row][col] = i + 1;
                if(++fillCount == 25)
                    printResult();
                if(col == 4) {
                    if(row < 4)
                        fill(row + 1, 0);
                } else
                    fill(row, col + 1);
                fillCount--;
                rowFilled[row][i] = false;
                colFilled[col][i] = false;
                if(row == col)
                    line1Filled[i] = false;
                if(row + col == 6)
                    line2Filled[i] = false;
            }
        }
    }
 
    private void printResult() {
    	String matchQuery = "";
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
            	if(datas[i][j]==1) {
            		//System.out.print("*");
            		matchQuery = matchQuery +""+i+""+j+"* ";
            	}
            	if(datas[i][j]==2){
            		//System.out.print(".");
            		matchQuery = matchQuery +""+i+""+j+". ";
            	}
            	if(datas[i][j]==3){
            		//System.out.print("S");
            		matchQuery = matchQuery +""+i+""+j+"S ";
            	}
            	if(datas[i][j]==4){
            		//System.out.print("T");
            		matchQuery = matchQuery +""+i+""+j+"T ";
            	}
            	if(datas[i][j]==5){
            		//System.out.print("C");
            		matchQuery = matchQuery +""+i+""+j+"C ";
            	}
            }
            //System.out.println();
        }
        //System.out.println();
        System.out.println(matchQuery+"END");
        //System.out.println("---------");
    }
}