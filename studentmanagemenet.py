MAX = 10
nim = [None] * MAX
nama = [None] * MAX
count = 0

def insert_beginning():
    global count
    if count == MAX:
        print("Array penuh!")
        return

    n = input("Masukkan NIM: ")
    nm = input("Masukkan Nama: ")

    for i in range(count, 0, -1):
        nim[i] = nim[i-1]
        nama[i] = nama[i-1]

    nim[0] = n
    nama[0] = nm
    count += 1

def insert_position():
    global count
    if count == MAX:
        print("Array penuh!")
        return

    pos = int(input(f"Posisi (0 - {count}): "))
    if pos < 0 or pos > count:
        print("Posisi tidak valid!")
        return

    n = input("Masukkan NIM: ")
    nm = input("Masukkan Nama: ")

    for i in range(count, pos, -1):
        nim[i] = nim[i-1]
        nama[i] = nama[i-1]

    nim[pos] = n
    nama[pos] = nm
    count += 1

def insert_end():
    global count
    if count == MAX:
        print("Array penuh!")
        return

    nim[count] = input("Masukkan NIM: ")
    nama[count] = input("Masukkan Nama: ")
    count += 1

def delete_beginning():
    global count
    if count == 0:
        print("Array kosong!")
        return

    for i in range(count - 1):
        nim[i] = nim[i + 1]
        nama[i] = nama[i + 1]
    count -= 1

def delete_position():
    global count
    if count == 0:
        print("Array kosong!")
        return

    pos = int(input(f"Posisi (0 - {count-1}): "))
    if pos < 0 or pos >= count:
        print("Posisi tidak valid!")
        return

    for i in range(pos, count - 1):
        nim[i] = nim[i + 1]
        nama[i] = nama[i + 1]
    count -= 1

def delete_end():
    global count
    if count == 0:
        print("Array kosong!")
        return
    count -= 1

def delete_first_occurrence():
    global count
    if count == 0:
        print("Array kosong!")
        return

    key = input("Masukkan NIM yang dicari: ")

    for i in range(count):
        if nim[i] == key:
            for j in range(i, count - 1):
                nim[j] = nim[j + 1]
                nama[j] = nama[j + 1]
            count -= 1
            return
    print("Data tidak ditemukan!")

def show_data():
    if count == 0:
        print("Array kosong!")
        return

    for i in range(count):
        print(f"{i}. {nim[i]} - {nama[i]}")

while True:
    print("\n1.Insert Beginning\n2.Insert Position\n3.Insert End")
    print("4.Delete Beginning\n5.Delete Position\n6.Delete End")
    print("7.Delete First Occurrence\n8.Show Data\n9.Exit")
    pilih = int(input("Pilih: "))

    if pilih == 1: insert_beginning()
    elif pilih == 2: insert_position()
    elif pilih == 3: insert_end()
    elif pilih == 4: delete_beginning()
    elif pilih == 5: delete_position()
    elif pilih == 6: delete_end()
    elif pilih == 7: delete_first_occurrence()
    elif pilih == 8: show_data()
    elif pilih == 9: break
