package Mmn12.Q2;

import java.util.ArrayList;

public class BigInt implements Comparable<BigInt> {

    private ArrayList _bigIntArrList;

    /**
     * Constructor
     */
    public BigInt(String bigInt) {
        _bigIntArrList = new ArrayList();
        if (bigInt.charAt(0) == '-' || bigInt.charAt(0) == '+') {
            _bigIntArrList.add(bigInt.charAt(0));
        } else {
            throw new IllegalArgumentException("Sign should be the first character!");
        }

        for (int i = 1; i < bigInt.length(); i++) {

            if (Character.isDigit(bigInt.charAt(i))) {
                _bigIntArrList.add(Character.getNumericValue(bigInt.charAt(i)));
            } else {
                throw new IllegalArgumentException("Input is not correct, please check your thought about integers - they are not who you think they are!!!");
            }


        }

    }

    public void plus(BigInt bigInt) {

        ArrayList bi = bigInt.get_bigIntArrList(), newBigInteger = new ArrayList();
        int len1 = length() - 1;
        int len2 = bigInt.length() - 1;
        boolean isPlusProcess = ((char) bi.get(0) == '-' && (char) _bigIntArrList.get(0) == '-' || (char) bi.get(0) == '+' && (char) _bigIntArrList.get(0) == '+');

        //we are in plus process - two sing are equals
        if (isPlusProcess) {
            newBigInteger.add(_bigIntArrList.get(0));
            for (int i = len1, j = len2; i > 0 && j > 0; i--, j--) {
                newBigInteger.add((int) _bigIntArrList.get(i) + (int) bi.get(j));
            }


        }
        //we are in minus process the sign is not equals
        else {

            if (compareAbsVal(this, bigInt) > 0) {
                newBigInteger.add(bi.get(0));
            } else {
                newBigInteger.add(_bigIntArrList.get(0));
            }

            for (int i = len1, j = len2; i > 0 && j > 0; i--, j--) {
                if ((int) bi.get(j) == 0 && (char) newBigInteger.get(0) == '-') {
                    newBigInteger.add((int) bi.get(j) - (int) _bigIntArrList.get(i));
                } else {
                    newBigInteger.add((int) _bigIntArrList.get(i) - (int) bi.get(j));
                }
            }
        }
        if (_bigIntArrList.size() > bi.size()) {
            for (int i = len1 - len2; i > 0; i--) {
                newBigInteger.add(_bigIntArrList.get(i));
            }
        } else {
            for (int i = len2 - len1; i > 0; i--) {
                newBigInteger.add(bi.get(i));
            }
        }
        //we finish with the calculate process and ned to adjust the array list to behave like an integer
        orderTheNumberAfterTheCalc(newBigInteger, isPlusProcess);

    }

    /**
     * Change the sign of the input number and use the plus function to do it
     */
    public void minus(BigInt bigInt) {
        char sign = bigInt.getSign() == '+' ? '-' : '+';
        bigInt.setSign(sign);
        plus(bigInt);
    }


    public void multiply(BigInt bigInt) {
        int len1 = length();
        int len2 = bigInt.length();
        String[][] mat = new String[len1 - 1][len2 - 1];
        BigInt newNumber = new BigInt("+0");
        for (int i = 0, x = len1 - 2; i < len1 - 1; i++, x--) {
            for (int j = 0, y = len2 - 2; j < len2 - 1; j++, y--) {

                mat[i][j] = Integer.toString(bigInt.getDigit(j) * getDigit(i));
                for (int z = 0; z < x + y && mat[i][j].charAt(0) != '0'; z++) {
                    mat[i][j] += "0";
                }
            }
        }

        for (int i = 0; i < len1 - 1; i++) {
            for (int j = 0; j < len2 - 1; j++) {
                newNumber.plus(new BigInt("+" + mat[i][j]));
            }
        }
        char sign = getSign() == bigInt.getSign() ? '+' : '-';
        newNumber.setSign(sign);
        this._bigIntArrList = newNumber.get_bigIntArrList();

    }

    public void divide(BigInt bigInt) {
        BigInt b1 = new BigInt("+0");
        //for 100/100 example...
        char sign = getSign() == bigInt.getSign() ? '+' : '-';
        if (bigInt.equals(b1)) {
            throw new ArithmeticException("Who you think you are? haaa? you can't divide in zero it's BAHAM!!!!");
        }
        if (this.equals(bigInt)) {
            b1._bigIntArrList.set(1, 1);
        } else {
            BigInt b2 = new BigInt(this.toString());
            //loop for b>p then a=a+1 ...
            b2.setSign('+');
            bigInt.setSign('+');
            while (compareAbsVal(b2, bigInt) < 1) {
                b2.minus(new BigInt(bigInt.toString()));
                b1.plus(new BigInt("+1"));
            }
        }

        b1.setSign(sign);
        _bigIntArrList = b1.get_bigIntArrList();
    }


    public ArrayList get_bigIntArrList() {
        return _bigIntArrList;
    }


    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < _bigIntArrList.size(); i++) {
            s += _bigIntArrList.get(i);
        }
        return s;
    }

    public boolean equals(BigInt p) {
        if (this.toString().equals(p.toString())) {
            return true;
        } else {
            return false;
        }
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
            if (this._bigIntArrList.size() > p._bigIntArrList.size()) {
                return -1;
            } else if (this._bigIntArrList.size() < p._bigIntArrList.size()) {
                return 1;
            } else {
                for (int i = 1; i < this._bigIntArrList.size(); i++) {
                    if ((int) this._bigIntArrList.get(i) > (int) p._bigIntArrList.get(i)) {
                        return -1;
                    } else if ((int) this._bigIntArrList.get(i) < (int) p._bigIntArrList.get(i)) {
                        return 1;
                    }
                }
            }

        } else {
            if (this._bigIntArrList.size() > p._bigIntArrList.size()) {
                return 1;
            } else if (this._bigIntArrList.size() < p._bigIntArrList.size()) {
                return -1;
            } else {
                for (int i = 1; i < this._bigIntArrList.size(); i++) {
                    if ((int) this._bigIntArrList.get(i) > (int) p._bigIntArrList.get(i)) {
                        return 1;
                    } else if ((int) this._bigIntArrList.get(i) < (int) p._bigIntArrList.get(i)) {
                        return -1;
                    }
                }
            }

        }
        return 0;
    }

    /**
     * This function will order the array list to bhave like an integer after the plus or minus process
     */
    private void orderTheNumberAfterTheCalc(ArrayList newBigInteger, boolean isPlusProcess) {
        int rest = 0;
        _bigIntArrList.set(0, newBigInteger.get(0));

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
            if (i < _bigIntArrList.size()) {
                _bigIntArrList.set(i, newBigInteger.get(j));
            } else {
                _bigIntArrList.add(i, newBigInteger.get(j));
            }
        }
        while (_bigIntArrList.size() > newBigInteger.size()) {
            _bigIntArrList.remove(_bigIntArrList.size() - 1);
        }

        if (_bigIntArrList.size() == 1) {
            _bigIntArrList.add(0);
        }

    }

    /**
     * This function check the abs value in two numbers
     */
    private int compareAbsVal(BigInt bigInt1, BigInt bigInt2) {
        BigInt b1 = new BigInt(bigInt1.toString()),
                b2 = new BigInt(bigInt2.toString());
        b1._bigIntArrList.set(0, '+');
        b2._bigIntArrList.set(0, '+');

        return b1.compareTo(b2);
    }

    public int getDigit(int index) {
        if (index < 0 || index >= this._bigIntArrList.size()) {
            System.out.println("No have any digit in index: " + index);
            return -1;
        }
        return (int) this._bigIntArrList.get(index + 1);
    }

    public void setDigit(int index, int digit) {
        if (index < 1 || index > _bigIntArrList.size()) {
            System.out.println("No have any digit in index: " + index);
        }
        this._bigIntArrList.set(index, digit);
    }

    public char getSign() {
        return (char) _bigIntArrList.get(0);
    }

    public void setSign(char sign) {
        if (sign != '-' && sign != '+') {
            System.out.println("sign should be plus or minus");
        } else {
            this._bigIntArrList.set(0, sign);
        }
    }

    public int length() {
        return this._bigIntArrList.size();
    }


}
