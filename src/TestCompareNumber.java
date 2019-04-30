public class TestCompareNumber {
    public static int compareVersion(String version1, String version2) {

        String[] versionOneArray = version1.split(".");
        String[] versionTwoArray = version2.split(".");
        int versionOneInt = 0;
        int versionTwoInt = 0;
        int i = 0;
        for ( i = 0; i<versionOneArray.length || i<versionTwoArray.length; i++) {
            versionOneInt = Integer.parseInt(versionOneArray[i]);
            versionTwoInt = Integer.parseInt(versionTwoArray[i]);

            if (versionOneInt > versionTwoInt)
                return 1;
            else if (versionOneInt < versionTwoInt)
                return -1;
        }

        if (versionOneArray.length == versionTwoArray.length) {
            return 0;
        } else if (versionOneArray.length > versionTwoArray.length){
            int remainNumber = Integer.parseInt(version1.substring(i));
            if (remainNumber == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            int remainNumber = Integer.parseInt(version2.substring(i));
            if (remainNumber == 0) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        String version1 = "1.1.1";
        String version2 = "1.0.2";
        System.out.println(compareVersion(version1, version2));
    }

}
