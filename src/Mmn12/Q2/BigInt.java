package Mmn12.Q2;


import java.util.ArrayList;

public class BigInt implements Comparable<BigInt> {

    private ArrayList _bigInt;

    public BigInt(String bigInt) {
        _bigInt = new ArrayList();
        if (bigInt.charAt(0) == '-' || bigInt.charAt(0) == '+') {
            _bigInt.add(bigInt.charAt(0));
        } else {
            throw new IllegalArgumentException("Sign should be the first character!");
        }

        for (int i = 1; i < bigInt.length(); i++) {

            if (Character.isDigit(bigInt.charAt(i))) {
                _bigInt.add(Character.getNumericValue(bigInt.charAt(i)));
            } else {
                throw new IllegalArgumentException("Input is not correct, please check your thought about integers - they are not who you think they are!!!");
            }


        }

    }

    public void plus(BigInt bigInt) {
        ArrayList bi = bigInt.get_bigInt(), newBigInteger = new ArrayList();
        int len1 = _bigInt.size() - 1;
        int len2 = bi.size() - 1;
        boolean isPlusProcess = ((char) bi.get(0) == '-' && (char) _bigInt.get(0) == '-' || (char) bi.get(0) == '+' && (char) _bigInt.get(0) == '+');
        if (isPlusProcess) {
            newBigInteger.add(_bigInt.get(0));
            for (int i = len1, j = len2; i > 0 && j > 0; i--, j--) {
                newBigInteger.add((int) _bigInt.get(i) + (int) bi.get(j));
            }


        } else {

            if (compareAbsVal(this, bigInt) > 0) {
                newBigInteger.add(bi.get(0));
            } else {
                newBigInteger.add(_bigInt.get(0));
            }

            for (int i = len1, j = len2; i > 0 && j > 0; i--, j--) {
                if ((int) bi.get(j) == 0 && (char) newBigInteger.get(0) == '-') {
                    newBigInteger.add((int) bi.get(j) - (int) _bigInt.get(i));
                } else {
                    newBigInteger.add((int) _bigInt.get(i) - (int) bi.get(j));
                }
            }
        }
        if (_bigInt.size() > bi.size()) {
            for (int i = len1 - len2; i > 0; i--) {
                newBigInteger.add(_bigInt.get(i));
            }
        } else {
            for (int i = len2 - len1; i > 0; i--) {
                newBigInteger.add(bi.get(i));
            }
        }
        orderTheNumberAfterTheCalc(newBigInteger, isPlusProcess);
    }

    public void minus(BigInt bigInt) {
        char sign = bigInt.getSign() == '+' ? '-' : '+';
        bigInt._bigInt.set(0, sign);
        plus(bigInt);
    }


    public void multiply(BigInt bigInt) {
        BigInt oldNumber = new BigInt(this.toString());

        char sign;
        if (getSign() == bigInt.getSign()) {
            sign = getSign();
        } else {
            sign = bigInt.getSign() == '+' ? '-' : '+';
        }


        for (int i = bigInt._bigInt.size() - 1, x = 0; i > 0; i--, x++) {
            for (int j = 1; j < (int) bigInt._bigInt.get(i) * Math.pow(10, x); j++) {
                plus(oldNumber);
            }
        }

        _bigInt.set(0, sign);
    }

    public void divide (BigInt p){
        BigInt a= new BigInt ("+0");
        //for 100/100 example...
        if (this.equals(p)){
            a._bigInt.set(1,1);
        }

        else{
            BigInt b= new BigInt (this.toString());
            BigInt c= new BigInt ("+1");
            //loop for b>p then a=a+1 ...
            while (b.compareTo(p)==1){
                b.minus(p);
               a.plus(c);
            }}
        char sign;
        if (getSign() == p.getSign()) {
            sign = getSign();
        } else {
            sign = p.getSign() == '+' ? '-' : '+';
        }
        _bigInt = a._bigInt;
    }



    public ArrayList get_bigInt() {
        return _bigInt;
    }


    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < _bigInt.size(); i++) {
            s += _bigInt.get(i);
        }
        return s;
    }

    public boolean equals(BigInt p) {
        if (this.toString().equals(p.toString())) {
            return true;
        } else return false;
    }

    @Override
    public int compareTo(BigInt p) {
        if (this.equals(p))
            return 0;
        if (this.getSign() == '-' && p.getSign() == '+') {
            return 1;
        } else if (this.getSign() == '+' && p.getSign() == '-') {
            return -1;
        } else if (this.getSign() == '+' && p.getSign() == '+') {
            if (this._bigInt.size() > p._bigInt.size()) {
                return -1;
            } else if (this._bigInt.size() < p._bigInt.size()) {
                return 1;
            } else {
                for (int i = 1; i < this._bigInt.size(); i++) {
                    if ((int) this._bigInt.get(i) > (int) p._bigInt.get(i)) {
                        return -1;
                    } else if ((int) this._bigInt.get(i) < (int) p._bigInt.get(i)) {
                        return 1;
                    }
                }
            }

        } else {
            if (this._bigInt.size() > p._bigInt.size()) {
                return 1;
            } else if (this._bigInt.size() < p._bigInt.size()) {
                return -1;
            } else {
                for (int i = 1; i < this._bigInt.size(); i++) {
                    if ((int) this._bigInt.get(i) > (int) p._bigInt.get(i)) {
                        return 1;
                    } else if ((int) this._bigInt.get(i) < (int) p._bigInt.get(i)) {
                        return -1;
                    }
                }
            }

        }
        return 0;
    }


    private void orderTheNumberAfterTheCalc(ArrayList newBigInteger, boolean isPlusProcess) {
        int rest = 0;
        _bigInt.set(0, newBigInteger.get(0));

        if (isPlusProcess) {
            for (int i = 1; i < newBigInteger.size(); i++) {
                if ((int) newBigInteger.get(i) + rest >= 10) {
                    int tmp = ((int) newBigInteger.get(i) + rest) / 10;
                    newBigInteger.set(i, (int) newBigInteger.get(i) + rest - 10);
                    rest = tmp;
                } else {
                    newBigInteger.set(i, (int) newBigInteger.get(i) + rest);
                    rest = 0;
                }
            }

        } else {
            while (newBigInteger.size() > 1 && (int) newBigInteger.get(newBigInteger.size() - 1) == 0) {
                newBigInteger.remove(newBigInteger.size() - 1);
            }
            for (int i = 1; i < newBigInteger.size(); i++) {
                if ((int) newBigInteger.get(i) - rest < 0) {
                    newBigInteger.set(i, (int) newBigInteger.get(i) - rest + 10);
                    rest = 1;
                } else {
                    newBigInteger.set(i, (int) newBigInteger.get(i) - rest);
                    rest = 0;
                }
            }
        }
        while (rest > 0) {
            newBigInteger.add(rest % 10);
            rest /= 10;
        }

        for (int i = 1, j = newBigInteger.size() - 1; j > 0; j--, i++) {
            if (i < _bigInt.size()) {
                _bigInt.set(i, newBigInteger.get(j));
            } else {
                _bigInt.add(i, newBigInteger.get(j));
            }
        }
        while (_bigInt.size() > newBigInteger.size()) {
            _bigInt.remove(_bigInt.size() - 1);
        }

        if (_bigInt.size() == 1) {
            _bigInt.add(0);
        }

    }

    private int compareAbsVal(BigInt bigInt1, BigInt bigInt2) {
        String s1 = bigInt1.toString(),
                s2 = bigInt2.toString();
        BigInt b1 = new BigInt(s1),
                b2 = new BigInt(s2);
        b1._bigInt.set(0, '+');
        b2._bigInt.set(0, '+');

        return b1.compareTo(b2);
    }

    private char getSign() {
        return (char) _bigInt.get(0);
    }
}
