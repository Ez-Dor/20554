package Mmn14.Q2;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    private TreeMap<String, String> _phoneBook;


    public PhoneBook() {
        this._phoneBook = new TreeMap<String, String>();
    }


    public PhoneBook(TreeMap<String, String> _phoneBook) {
        this._phoneBook = _phoneBook;
    }


    public void add(String name, String phone) {

        this._phoneBook.put(name, phone);
    }


    public boolean remove(String name) {

        name = name.trim();
        return this._phoneBook.remove(name) != null;

    }


    public boolean update(String name, String newName, String phoneNumber) {

        name = name.trim();
        newName = newName.trim();
        if (this._phoneBook.remove(name) == null) {
            return false;
        }
        this._phoneBook.put(newName, phoneNumber);
        return true;

    }


    public void saveAsFile(String fileName) throws IOException {

        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Map.Entry<String, String> entry : _phoneBook.entrySet()) {
            String name = entry.getKey();
            String phone = entry.getValue();

            bufferedWriter.write(name + "=" + phone + "\n");
        }

        bufferedWriter.close();
    }


    public void loadFromFile(String filePath) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
        String line;
        int lineNumber = 0;
        _phoneBook = new TreeMap<String, String>();

        while ((line = bufferedReader.readLine()) != null) {
            lineNumber++;
            if (line.contains("=")) {
                String[] strings = line.split("=");
                this.add(strings[0].trim(), strings[1].trim());
            }
        }
        bufferedReader.close();
    }

/*
    public TreeMap filter(String stringToFind) {

        stringToFind = stringToFind.trim();
        if (stringToFind.equals("") || stringToFind.equals(null)) return new TreeMap(this._phoneBook);
        String fromKye = this.findFirstProperKye(stringToFind);
        String toKye = this.findLastKyeToFind(stringToFind);
        if (fromKye == null) return new TreeMap();
        return new TreeMap(this._phoneBook.subMap(fromKye, true, toKye, true));
    }*/


    public String getPhone(String name) {
        return _phoneBook.get(name);

    }


    /*//find first value equals or bigger than the kye name
    private String findFirstProperKye(String stringToFind) {

        Set<String> names = _phoneBook.keySet();
        for (String kye : names) {
            int correctChars = 0;
            for (int i = 0; i < stringToFind.length() && i < kye.length(); i++) {
                if (stringToFind.charAt(i) == kye.charAt(i)) correctChars++;
                if (correctChars == stringToFind.length()) return kye;
            }
        }
        return null;
    }*/



    /*private String findLastKyeToFind(String stringToFind) {

        Set<String> names = _phoneBook.keySet();
        String properKye = null;
        for (String kye : names) {
            int correctChars = 0;
            for (int i = 0; i < stringToFind.length() && i < kye.length(); i++) {
                if (stringToFind.charAt(i) == kye.charAt(i)) correctChars++;
                if (correctChars == stringToFind.length()) properKye = kye;
            }
        }
        return properKye;
    }*/

    @Override
    public String toString() {
        return "PhoneBook{" +
                "_phoneBook=" + _phoneBook +
                '}';
    }
}
