import java.util.Scanner;

public class ArrayMahasiswa {
    static final int MAX = 10;
    static String[] nim = new String[MAX];
    static String[] nama = new String[MAX];
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    // Insert at beginning
    static void insertBeginning() {
        if (count == MAX) {
            System.out.println("Array penuh!");
            return;
        }

        System.out.print("Masukkan NIM: ");
        String n = sc.nextLine();
        System.out.print("Masukkan Nama: ");
        String nm = sc.nextLine();

        for (int i = count; i > 0; i--) {
            nim[i] = nim[i - 1];
            nama[i] = nama[i - 1];
        }

        nim[0] = n;
        nama[0] = nm;
        count++;
    }

    // Insert at given position
    static void insertPosition() {
        if (count == MAX) {
            System.out.println("Array penuh!");
            return;
        }

        System.out.print("Posisi (0 - " + count + "): ");
        int pos = Integer.parseInt(sc.nextLine());

        if (pos < 0 || pos > count) {
            System.out.println("Posisi tidak valid!");
            return;
        }

        System.out.print("Masukkan NIM: ");
        String n = sc.nextLine();
        System.out.print("Masukkan Nama: ");
        String nm = sc.nextLine();

        for (int i = count; i > pos; i--) {
            nim[i] = nim[i - 1];
            nama[i] = nama[i - 1];
        }

        nim[pos] = n;
        nama[pos] = nm;
        count++;
    }

    // Insert at end
    static void insertEnd() {
        if (count == MAX) {
            System.out.println("Array penuh!");
            return;
        }

        System.out.print("Masukkan NIM: ");
        nim[count] = sc.nextLine();
        System.out.print("Masukkan Nama: ");
        nama[count] = sc.nextLine();
        count++;
    }

    // Delete from beginning
    static void deleteBeginning() {
        if (count == 0) {
            System.out.println("Array kosong!");
            return;
        }

        for (int i = 0; i < count - 1; i++) {
            nim[i] = nim[i + 1];
            nama[i] = nama[i + 1];
        }
        count--;
    }

    // Delete given position
    static void deletePosition() {
        if (count == 0) {
            System.out.println("Array kosong!");
            return;
        }

        System.out.print("Posisi (0 - " + (count - 1) + "): ");
        int pos = Integer.parseInt(sc.nextLine());

        if (pos < 0 || pos >= count) {
            System.out.println("Posisi tidak valid!");
            return;
        }

        for (int i = pos; i < count - 1; i++) {
            nim[i] = nim[i + 1];
            nama[i] = nama[i + 1];
        }
        count--;
    }

    // Delete from end
    static void deleteEnd() {
        if (count == 0) {
            System.out.println("Array kosong!");
            return;
        }
        count--;
    }

    // Delete first occurrence
    static void deleteFirstOccurrence() {
        if (count == 0) {
            System.out.println("Array kosong!");
            return;
        }

        System.out.print("Masukkan NIM yang dicari: ");
        String key = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (nim[i].equals(key)) {
                for (int j = i; j < count - 1; j++) {
                    nim[j] = nim[j + 1];
                    nama[j] = nama[j + 1];
                }
                count--;
                return;
            }
        }
        System.out.println("Data tidak ditemukan!");
    }

    // Show data
    static void showData() {
        if (count == 0) {
            System.out.println("Array kosong!");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(i + ". " + nim[i] + " - " + nama[i]);
        }
    }

    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("\n1.Insert Beginning\n2.Insert Position\n3.Insert End");
            System.out.println("4.Delete Beginning\n5.Delete Position\n6.Delete End");
            System.out.println("7.Delete First Occurrence\n8.Show Data\n9.Exit");
            System.out.print("Pilih: ");
            pilih = Integer.parseInt(sc.nextLine());

            switch (pilih) {
                case 1: insertBeginning(); break;
                case 2: insertPosition(); break;
                case 3: insertEnd(); break;
                case 4: deleteBeginning(); break;
                case 5: deletePosition(); break;
                case 6: deleteEnd(); break;
                case 7: deleteFirstOccurrence(); break;
                case 8: showData(); break;
            }
        } while (pilih != 9);
    }
}
