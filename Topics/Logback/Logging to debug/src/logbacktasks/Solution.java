package logbacktasks;

import org.slf4j.*;

public class Solution {
    static final Logger LOG = LoggerFactory.getLogger(Solution.class);

    public int add(int arg1, int arg2) {
        int sum = arg1 + arg2;
        LOG.debug("arg1={}, arg2={}, sum={}", arg1, arg2, sum);
        return sum;
    }
}

/*class Testus {
    public static void main(String[] args) {
        new Solution().add(3, 5);
    }
}*/
