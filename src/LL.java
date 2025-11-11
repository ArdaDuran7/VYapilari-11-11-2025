public class LL {

    //Node = Düğüm
    //172. satırda Node sınıfı tanımlı.

    //Düğüm sınıfı tipinde: Baş
    private Node head;
    //Düğüm sınıfı tipinde: Kuyruk
    private Node tail;
    //Liste Uzunluğu
    private int size;

    //Constructor (LinkedList için, boyutu 0 atandı. head ve tail null(Boş değer) olarak atandı.
    public LL() {
        this.size = 0;
    }

    //Başa düğüm koyma metodu (int (tam sayi) tipinde parametre alıyor: val)
    public void insertFirst(int val) {
        //Düğüm sınıfı tipinde, node adında, val değişkenini parametresi ile bir nesne oluşturuyoruz.
        Node node = new Node(val);
        //node nesnesi, head'i gösteriyor. Listenin başına geçiyor çünkü listenin başını gösteriyor.
        node.next = head;
        //head, node nesnesine geçiyor. Çünkü listenin başına geçtiği için artık head ünvanını alması lazım.
        head = node;

        //tail (kuyruk) null (Boş değer) ise:
        if (tail == null) {
            //tail, head'e eşitleniyor. Yani kuyruk başın olduğu yere eşitleniyor, değeri yok ise.
            //NOT (ARKASINDAKİ MANTIK): BU METOD ÇAĞRILDIĞINDA EĞER BİR LİSTE YOKSA NE HEAD NE DE TAİL
            //BİR DEĞERE SAHİP. YANİ İKİSİ DE NULL. BU METOD SADECE BİR KERE ÇALIŞIYOR, O DA İLK ELEMAN
            //EKLENDİĞİNDE.
            tail = head;
            //ARTIK LİSTENİN BİR ELEMANI VAR, VE LİSTENİN TEK ELEMANI OLDUĞU İÇİN O ELEMAN HEM BAŞ HEM KUYRUK.
        }
        //Bir ekleme yapıldığı için liste boyutu bir arttı. size değişkenini bir artırdık bu yüzden.
        size += 1;
    }
    //Sona düğüm koyma metodu (int (tam sayi) tipinde parametre alıyor: val)
    public void insertLast(int val) {
        //Yukarıda bahsettiğim gibi, bir defa çalışacak olan metod. Kuyruğu var mı diye kontrol ediyor, liste var mı
        //diye kontrol etmekten farksız. Sona ekleme ve başa ekleme hiç eleman olmadığı zaman aynı sonuca çıktığı için
        //başa ekleme komutu çağrılmış, aynı val değişkeni ile.
        if (tail == null) {
            insertFirst(val);
            return;
        }
        //Düğüm sınıfı tipinde, node adında, val değişkenini parametresi ile bir nesne oluşturuyoruz.
        Node node = new Node(val);
        //Kuyruktan sonra, düğüm yoktur. Burada next yani kuyruğun sonrasına yeni node değişkenimizi koyuyoruz.
        //Yeni düğüm listenin artık sonunda.
        tail.next = node;
        //Yeni düğüm artık listenin sonunda olduğu için tail'i (kuyruğu) node düğümüne eşitliyoruz.
        //Düğümümüz artık tail'ı (kuyruk) kendine aldı.
        tail = node;
        //Ekleme gerçekleştiği için size (boyut) değişkenini bir artırıyoruz.
        size++;
    }
    //Düğüm koyma metodu (int (tam sayi) tipinde parametre alıyor: val, int (tam sayi) tipinde parametre alıyor: index)
    //val burada içindeki değer, index ise düğümün ekleneceği sıra
    public void insert(int val, int index) {
        //index, 0 ise. Yani listenin başına eklenicekse, başa ekle metodu çağrılıyor.
        if (index == 0) {
            insertFirst(val);
            return;
        }
        //index, size(boyut/listenin boyutu) ise. Yani listenin sonuna eklenicekse, sona ekle metodu çağrılıyor.
        if (index == size) {
            insertLast(val);
            return;
        }
        //İki koşul da çalışmadı, demektir ki ne başa ne sona konucak. Araya konucak bir düğüm bu.
        //Geçici bir düğüm tipinde değişken (Constructor kullanmadık) oluşturuyoruz. Bu nesne head(listenin başını) gösteriyor.
        Node temp = head;
        //int i = 1 için i<index kadar. Yani gideceği yere kadar çalışması lazım.
        for (int i = 1; i < index; i++) {
            //temp = temp.next, bu geçiçi düğümü kendinden sonraki değere eşitliyor. Yani aslında geçici düğüm bir ileri gidiyor
            //Ben, benden sonrakiyim diyor, (TÜRKÇE MEALİ)
            temp = temp.next;
        }

        //Az önceki for döngüsü ile gereken konuma vardık. Eklenecek düğüm bulduğumuz konumdaki düğümden hemen sonra gelicek.
        //Bu yüzden node nesnesi oluşurken, new Node(val, temp.next) => Burada temp.next diyoruz. Çünkü durduğumuz noktadaki düğümden SONRA
        //gelicek ve val değerini taşıcak.
        Node node = new Node(val, temp.next);
        //Adresini ve tuttuğu değeri belirlediğimiz düğümü, temp.next'e  yani belirlediğimiz noktaya yerleştirdik.
        temp.next = node;
        //Ekleme gerçekleşti. Bu yüzden boyut değişkenini bir artırdık.
        size++;
    }
    //Listeden son düğümü sil metodu. Parametre almıyor.
    public int deleteLast() {
        //Eğer boyutu bir veya birden azsa, ilkini sil metodu çağrılır. Çünkü metodlar aynı işlevi görüyor zaten.
        if (size <= 1) {
            return deleteFirst();
        }
        //secondLast (Sondan ikinci) adında, Düğüm tipinde bir değişken oluşturulur.
        //Aşağıda belirlediği get metodu ile düğüm, listenin sondan ikinci elemanı ile aynı özellikleri taşıyor.
        Node secondLast = get(size - 2);
        //val adında bir tam sayı değişkeni, listenin kuyruğundaki tam sayı değerini alır.
        int val = tail.value;
        //Kuyruk secondLast (sondan ikinci) olarak adlandırdığımız düüğüm olur.
        tail = secondLast;
        //Sondan ikinci değer olarak adlandırdığımız, artık null(boş değer) gösterir. Yani kendinden sonra bir
        //düğüm göstermez artık.
        //Bu şekilde son elemanı aslında listeden kaldırmış oluruz.
        tail.next = null;
        //Silindiği için, size değişkenimizi bir azaltırız.
        size--;
        //val değişkenini return ederiz.
        return val;
    }
    //Listeden düğüm silme metodu. Parametre olarak, silinecek adresi belirleyecek olan
    // int (tam sayı) tipinde index adlı değişkeni alıyor)
    public int delete(int index) {
        //index 0 ise, yani ilk eleman ise deleteFirst (İlkini sil) metodu çağrılıyor.
        if (index == 0) {
            return deleteFirst();
        }
        //index boyuttan bir az ise (listelerde ilk eleman 0. eleman, bu yüzden son eleman boyutun
        // bir altı olarak gösterilir), yani son eleman ise deleteLast (Sonuncuyu sil) metodu çağrılıyor.
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}