class Solution {
    public ArrayList<String> graycode(int n) {
        // code here
        if (n == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }

        ArrayList<String> rres = graycode(n - 1);
        ArrayList<String> mres = new ArrayList<>();

        for (int i = 0; i < rres.size(); i++) {
            String str = rres.get(i);
            mres.add("0" + str);
        }

        for (int i = rres.size() - 1; i >= 0; i--) {
            String str = rres.get(i);
            mres.add("1" + str);
        }

        return mres;
    }
}