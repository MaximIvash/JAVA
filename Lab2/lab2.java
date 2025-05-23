package lab2;
import java.util.Objects;

public class lab2 {
    public String getGreeting() {
        return "Hello World!";
    }

    static public String SubStr(String str){
        String answer = "";
        int buf[] = new int[255];
        for(char i = 'A'; i!='z'; i++){
            buf[(int)(i)] = 0;
        }

        int j = 0;
        String tmp = "";
        for(int i = 0; i<str.length();i++){
            tmp += str.charAt(i);
            buf[(int)str.charAt(i)] += 1;
            if(buf[(int)str.charAt(i)] == 2){
                if(str.substring(j, i).length() > answer.length()){
                    answer = str.substring(j, i);
                }
                while(buf[(int)str.charAt(i)] != 1){
                    buf[(int)str.charAt(j)] -= 1;
                    j++;
                }
                tmp = str.substring(j, i + 1);
            }
        }
        return answer;
    }

    public static int MaxSubArraySum(int[] arr){
        int ans = arr[0];
        int total = 0;

        for(int i = 0;i<arr.length;i++){
            if(total < 0){
                total = 0;
            }
            total += arr[i];
            ans = Math.max(ans, total);
        }

        return ans;
    }

    public static int[] ConcatenateArrays(int[] arr1, int[] arr2){
        int new_len = arr1.length + arr2.length;
        int[] answer = new int[new_len];
        int counter = 0;
        for(int i = 0;i<arr1.length;i++){
            answer[counter++] = arr1[i];
        }
        for(int i = 0;i<arr2.length;i++){
            answer[counter++] = arr2[i];
        }
        for(int i = 0;i<new_len;i++){
            for(int j = i + 1;j<new_len;j++){
                if(answer[j] < answer[i]){
                    int tmp = answer[j];
                    answer[j] = answer[i];
                    answer[i] = tmp;
                }
            }
        }

        return answer;
    }

    public static int TwoArraySum(int[][] mat){
        int sum = 0;
        for(int i = 0;i<mat.length;i++){
            for(int j = 0; j<mat[i].length;j++){
                sum += mat[i][j];
            }
        }
        return sum;
    }

    public static void printMat(int[][] mat){
        for(int i = 0;i<mat.length;i++){
            for(int j = 0; j<mat[i].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int[] MaxNumInRow(int[][] mat){
        int[] ans = new int[mat.length];
        int count = 0;
        for(int i = 0;i<mat.length;i++){
            int max = -999999;
            for(int j = 0;j<mat[i].length;j++){
                if(mat[i][j] > max){
                    max = mat[i][j];
                }
            }
            ans[count++] = max;
        }
        return ans;
    }

    public static int[][] rotateMatrixRight(int[][] mat) {
        int[][] rotated = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                rotated[j][i] = mat[mat.length-i-1][j];
        return rotated;
    }

    public static int[][] rotateMatrixLeft(int[][] mat) {
        int[][] rotated = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                rotated[j][i] = mat[i][mat.length-j-1];
        return rotated;
    }

    public static int[] TwoNumSum(int[] arr, int target){
        int[] ans = new int[2];
        for(int i = 0;i<arr.length;i++){
            for(int j = i; j<arr.length;j++){
                if(arr[i] + arr[j] == target){
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                    break;
                }
            }
        }
        if (Objects.isNull(ans[0])){
            return null;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

        String str = "abcadefggge";
        String maxSub = SubStr(str);
        System.out.println("task 1: " + str + " max sub: " +  maxSub);

        System.out.print("task 2: ");
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {6,7,8,9,10};
        int[] con = ConcatenateArrays(arr2, arr1);
        for(int i = 0;i<con.length;i++){
            System.out.print(con[i] + " ");
        }
        System.out.println();

        int[] array = {-3,10,-2,1,1,5,-6};
        System.out.println("task 3: " + MaxSubArraySum(array));


        System.out.println("task4: ");
        int[][] rotated = rotateMatrixRight(mat);
        printMat(rotated);

        int[] arr = {1,2,3,9,0,0,0,1,2,3};
        int[] ans = TwoNumSum(arr, 12);
        System.out.println("taks 5: " + ans[0] + " " + ans[1]);


        System.out.println("task6: " + TwoArraySum(mat));

        int[] a = MaxNumInRow(mat);
        System.out.print("task7: ");
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println("task8:");
        int[][] rot = rotateMatrixLeft(mat);
        printMat(rot);
    }
}