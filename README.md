# Advanced Programming - Aliyah Faza Qinthara

### Contents
* [Tutorial 1](#tutorial-1)
* [Tutorial 2](#tutorial-2)

<a name="tutorial-1"></a>
## Tutorial 1 - Reflection

### Reflection 1
Setelah meninjau kode yang ditulis, terlihat bahwa standar pemrograman Java dan Spring Framework telah diikuti dengan baik. Anotasi seperti `@Controller`, `@Service`, dan `@Repository` telah digunakan dengan benar dan `@Autowired` digunakan untuk dependency injection.

Dalam hal prinsip clean code, kode mudah dibaca dan dipahami. Logika bisnis telah dipisahkan ke dalam layanan yang berbeda dan tidak ada pengulangan kode, yang merupakan praktik baik. Setiap kelas memiliki tanggung jawab yang jelas dan terpisah.

Mengenai praktik pengkodean yang aman, tidak ada informasi sensitif atau rahasia yang ditampilkan dalam kode. Namun, perlu dipastikan bahwa input pengguna divalidasi sebelum digunakan dalam aplikasi untuk mencegah serangan seperti SQL Injection.

Ada beberapa saran untuk perbaikan. Pertama, penambahan validasi input pengguna di `ProductController` bisa meningkatkan keamanan. Kedua, dalam `ProductRepository`, metode `findAll()` sebaiknya mengembalikan `List<Product>` daripada `Iterator<Product>`. Terakhir, pertimbangkan penggunaan database nyata daripada menggunakan `ArrayList` sebagai database mockup.

### Reflection 2
Saya merasa pua setelah melakukan _unit test_. Terdapat tiga _unit test_ pada kelas `ProductTest` dan lima fungsi _unit test_ pada kelas `ProductRepositoryTest`. Kita dapat memastikan _unit test_ kita sudah berjalan benar dengan memastikan semua tesnya lulus.


<a name="tutorial-2"></a>
## Tutorial 2 - Reflection
1. Salah satu isu dari hasil _code scanning_ di SonarCloud, yaitu `redirect:list` yang diulang sebanyak tiga kali. Jadi, saya mendefinisikan _constant_ untuk `redirect:list` sehingga pemakaiannya lebih baik.
2. Menurut saya, _workflow_ saya sudah cukup memenuhi standar CI/CD. Dalam `ci.yml`, _workflow_ sudah ke-_trigger_ untuk setiap _push & pull request_. Ini berarti kode di-_build_ dan dites secara berkala. Terdapat pula _workflow_ untuk men-_trigger_ _deployment_ setiap _push_ ke master. Ini berarti setiap perubahan yang lulus _testing_ akan otomatis ter-_deploy_—hal ini memenuhi esensi CD.