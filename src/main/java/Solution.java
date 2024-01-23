import java.util.List;

public class Solution {
    public int maxLength(List<String> arr) {
        return dfs(arr, 0, 0);
    }
    private int dfs (List<String> arr, int i, int mask){
        if(arr.size() == i){
            return 0;
        }

        int result = 0;
        int take = 0;
        int skip = 0;

        String str = arr.get(i);
        int strMask = 0;
        boolean hasDuplicates = false;
        for(int j = 0; j < str.length(); j++){
            if((strMask & (1 << (str.charAt(j) - 'a'))) != 0){
                hasDuplicates = true;
                break;
            }

            strMask |= 1 << (str.charAt(j) - 'a');
        }
        if(((!hasDuplicates) && ((strMask & mask)) == 0)){
            take = str.length() + dfs(arr, i + 1, mask | strMask);
        }

        skip = dfs(arr, i + 1, mask);
        result = Math.max(take, skip);

        return result;
    }
}
