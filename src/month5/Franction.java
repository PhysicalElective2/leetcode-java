package month5;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author shaoxi
 * @version 0.1.0
 * @create 2021-05-08 20:21
 **/
public class Franction {
    static class Fraction {
        int up;
        int down;

        public Fraction(int a, int b) {
            up = a;
            down = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraction fraction = (Fraction) o;
            return up == fraction.up && down == fraction.down;
        }

        @Override
        public int hashCode() {
            return Objects.hash(up, down);
        }
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public Fraction reduction(Fraction result) {
        if (result.down < 0) {
            result.up = -result.up;
            result.down = -result.down;
        }
        if (result.up == 0) {
            result.down = 1;
        } else {
            int key = gcd(Math.abs(result.up), Math.abs(result.down));
            result.down /= key;
            result.up /= key;
        }
        return result;
    }


    public int getRes(int[] x, int[] y) {
        Map<Fraction, Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            Fraction temp = reduction(new Fraction(x[i], y[i]));
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Fraction, Integer> entry : map.entrySet()) {
            Fraction key = entry.getKey();
            if (key.up != 1 && key.down != 2) {
                for (Map.Entry<Fraction, Integer> entry2 : map.entrySet()) {
                    if (entry2.getKey().up * key.down + key.up * entry2.getKey().down == entry2.getKey().down * key.down) {
                        res = (res + entry2.getValue() * entry.getValue()) % (1000000007);
                        map.put(entry2.getKey(), 0);
                        break;
                    }
                }
            } else {
                res = (res + (entry.getValue() * entry.getValue() - entry.getValue()) / 2) % (1000000007);
            }
        }
        return res;
    }
}
