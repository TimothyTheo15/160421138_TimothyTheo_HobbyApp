-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2024 at 01:05 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cats`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `id` int(11) NOT NULL,
  `subtitle` varchar(45) NOT NULL,
  `paragraph` varchar(450) NOT NULL,
  `beritas_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`id`, `subtitle`, `paragraph`, `beritas_id`) VALUES
(1, 'Gunakan Bola Pingpong', 'Anak kucing akan sangat senang bermain bola pingpong. Lemparkan bola dan biarkan si manis mengerjarnya. Bola pingpong memantul dengan sangat mudah, sehingga dapat bergerak cepat.', 1),
(2, 'Gunakan Lonceng', 'Kucing sangat tertarik dengan bunyi-bunyi yang lucu seperti lonceng. Bunyikan loncengmu dan kucing akan datang mengampirimu untuk bermain. Bunyikan beberapa kali agar si kucing senang.', 1),
(3, 'Gunakan Bola Tennis', 'Bola tennis memiliki warna yang menyala seperti hijau stabilo. Kucing sangat menyukai warna tersebut sehingga ia akan mengejarnya dan menggigitnya untuk dibawakan kepada anda.', 1),
(4, 'Pilih Reward yang Tepat', 'Setiap anjing memiliki reward favoritnya. Beberapa anjing suka makanan, sementara yang lain suka mainan. Cari tahu apa yang paling disukai anjing Anda dan gunakan sebagai reward selama pelatihan.', 2),
(5, 'Berikan Pujian', 'Selain reward, anjing juga butuh pujian verbal. Katakan \'baik\' atau \'bagus\' saat anjing melakukan sesuatu dengan benar. Pujian akan memperkuat perilaku yang diinginkan.', 2),
(6, 'Jadwalkan Latihan Rutin', 'Konsistensi sangat penting dalam pelatihan anjing. Tetapkan jadwal latihan yang konsisten setiap hari agar anjing Anda cepat belajar dan terbiasa dengan perintah-perintah baru.', 2),
(7, 'Sediakan Makanan Berfiber', 'Kelinci membutuhkan makanan yang tinggi serat seperti rumput, daun hijau, dan sayuran. Pastikan selalu menyediakan makanan berfiber ini agar pencernaan kelinci tetap sehat.', 3),
(8, 'Berikan Ruang Gerak yang Cukup', 'Kelinci senang bergerak dan melompat. Pastikan kandang atau ruang gerak kelinci Anda cukup luas agar dia bisa bergerak dengan bebas dan tidak merasa terkekang.', 3),
(9, 'Beri Mainan untuk Hewan', 'Kelinci juga perlu stimulasi mental dan fisik. Berikan mainan seperti bola kecil atau balok kayu untuk menghindari kebosanan dan menjaga kesehatannya.', 3),
(10, 'Ganti Air Secara Rutin', 'Air dalam akuarium harus diganti secara rutin untuk menghindari penumpukan kotoran dan zat berbahaya. Ganti sebagian air setiap minggu untuk menjaga kualitas air.', 4),
(11, 'Bersihkan Dekorasi Akuarium', 'Dekorasi seperti batu dan tanaman juga perlu dibersihkan dari lumut dan kotoran. Bersihkan dekorasi secara berkala agar tetap menarik dan tidak mengganggu kesehatan ikan.', 4),
(12, 'Periksa Sistem Filter', 'Filter adalah komponen penting dalam menjaga kualitas air. Periksa sistem filter secara teratur dan bersihkan jika diperlukan agar tetap berfungsi dengan baik.', 4),
(13, 'Perhatikan Ekspresi Wajah', 'Ekspresi wajah burung bisa memberikan petunjuk tentang perasaannya. Pelajari ekspresi wajah burung Anda untuk memahami apakah dia sedang bahagia, takut, atau sakit.', 5),
(14, 'Amati Gerakan Tubuh', 'Gerakan tubuh burung juga bisa mengindikasikan perasaannya. Perhatikan apakah burung Anda bergerak aktif atau malas, apakah dia menggembungkan bulunya, atau apakah dia berdiri tegak.', 5),
(15, 'Pahami Suara Burung', 'Suara burung adalah cara komunikasi utamanya. Pelajari berbagai suara yang dihasilkan burung Anda untuk memahami apa yang dia coba sampaikan.', 5),
(16, 'Pilih Ikan yang Sesuai dengan Ukuran Akuarium', 'Pastikan ikan yang Anda pilih sesuai dengan ukuran akuarium Anda. Jangan pilih ikan yang terlalu besar untuk akuarium kecil, karena hal ini dapat mengganggu kesehatan ikan dan kualitas air.', 6),
(17, 'Perhatikan Kebutuhan Suhu', 'Setiap jenis ikan memiliki kebutuhan suhu air yang berbeda. Pastikan suhu air dalam akuarium sesuai dengan kebutuhan ikan yang Anda pilih untuk menjaga kesehatannya.', 6),
(18, 'Pelajari Perilaku Ikan', 'Beberapa ikan bersifat agresif dan tidak cocok dipelihara bersama ikan lain. Pelajari perilaku ikan yang Anda pilih agar dapat membuat kombinasi yang harmonis dalam akuarium Anda.', 6),
(19, 'Sisir Bulu Secara Teratur', 'Sisir bulu anjing Anda secara teratur untuk menghilangkan rambut mati dan mencegah pembentukan matting. Sisir dengan lembut dan hindari menarik bulu yang terlalu keras.', 7),
(20, 'Mandi dengan Produk yang Sesuai', 'Pilih produk mandi yang sesuai dengan jenis bulu dan kulit anjing Anda. Gunakan sampo dan kondisioner khusus anjing yang tidak mengandung bahan kimia keras.', 7),
(21, 'Periksa dan Bersihkan Telinga', 'Periksa telinga anjing Anda secara teratur untuk memastikan tidak ada infeksi atau kotoran yang mengganggu. Bersihkan telinga dengan lembut menggunakan kapas dan cairan pembersih telinga khusus.', 7),
(22, 'Pilih Terrarium yang Sesuai', 'Terrarium harus sesuai dengan ukuran dan spesies reptil Anda. Pastikan memiliki ventilasi yang cukup, ruang berjemur, dan area bersembunyi.', 8),
(23, 'Sediakan Pencahayaan yang Cukup', 'Reptil membutuhkan pencahayaan UVB untuk sintesis vitamin D. Sediakan lampu UVB yang tepat untuk spesies reptil Anda agar kesehatannya tetap terjaga.', 8),
(24, 'Atur Suhu yang Optimal', 'Suhu dalam terrarium harus diatur sesuai dengan kebutuhan reptil Anda. Gunakan termometer dan pemanas untuk menciptakan lingkungan yang hangat dan nyaman.', 8),
(25, 'Pelajari Kebutuhan Makanan', 'Setiap hewan eksotis memiliki kebutuhan makanan yang unik. Pelajari tentang makanan yang diperlukan hewan peliharaan Anda dan pastikan Anda dapat menyediakannya dengan baik.', 9),
(26, 'Pertimbangkan Ruang dan Kandang', 'Beberapa hewan eksotis memerlukan kandang atau ruang khusus untuk memenuhi kebutuhan hidupnya. Pastikan Anda memiliki ruang yang cukup dan sesuai untuk hewan peliharaan Anda.', 9),
(27, 'Periksa Kebutuhan Kesehatan', 'Sebelum memelihara hewan eksotis, pastikan Anda memahami kebutuhan kesehatannya. Beberapa hewan memerlukan perawatan khusus dan pemeriksaan rutin oleh dokter hewan.', 9),
(28, 'Berikan Perhatian yang Cukup', 'Hewan peliharaan Anda membutuhkan perhatian dan kasih sayang. Luangkan waktu untuk bermain, melatih, dan menghabiskan waktu bersama hewan peliharaan Anda setiap hari.', 10),
(29, 'Pastikan Kesehatan yang Optima', 'Perawatan kesehatan rutin sangat penting untuk mencegah penyakit dan masalah kesehatan lainnya. Pastikan vaksinasi dan pemeriksaan rutin oleh dokter hewan dilakukan secara teratur.', 10),
(30, 'Ciptakan Lingkungan yang Nyaman', 'Lingkungan yang nyaman dan aman sangat penting untuk kesejahteraan hewan peliharaan Anda. Pastikan kandang, akuarium, atau terrarium sesuai dengan kebutuhan spesies hewan Anda.', 10);

-- --------------------------------------------------------

--
-- Table structure for table `beritas`
--

CREATE TABLE `beritas` (
  `id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `description` varchar(245) NOT NULL,
  `photo_url` varchar(450) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `beritas`
--

INSERT INTO `beritas` (`id`, `title`, `description`, `photo_url`, `user_id`) VALUES
(1, 'Playing With Your Cats', 'Kucing bisa stress. Luangkan waktu untuk bermain 30-60 menit dengan kucingmu setiap hari. Baca permainan apa yang disukai kucing di artikel ini.', 'https://i0.wp.com/joglosemarnews.com/images/2023/01/kucing.jpg?fit=1280%2C853&ssl=1', 1),
(2, 'Tips for Training Your Dog', 'Pelatihan anjing membutuhkan kesabaran dan konsistensi. Gunakan tips ini untuk membantu melatih anjing Anda dengan baik.', 'https://www.forbes.com/advisor/wp-content/uploads/2023/09/most-popular-dog-breeds.jpeg-900x510.jpg', 2),
(3, 'How to Care for Your Pet Rabbit', 'Kelinci adalah hewan yang memerlukan perawatan khusus. Pelajari cara merawat kelinci Anda dengan benar agar tetap sehat dan bahagia.', 'https://i0.wp.com/newspack-berkeleyside-cityside.s3.amazonaws.com/wp-content/uploads/2023/12/IMG_1207_2-scaled.jpg?resize=1200%2C900&ssl=1', 3),
(4, 'Keeping Your Fish Tank Clean', 'Mempelihara akuarium ikan membutuhkan perawatan rutin. Ikuti tips ini untuk menjaga akuarium Anda tetap bersih dan ikan Anda sehat.', 'https://content.osgnetworks.tv/floridasportsman/content/photos/10-most-unique-deep-sea-fishing-catches-gorgeous-swallowtail-1200x800.jpg', 4),
(5, 'Understanding Your Pet Bird\'s Behavior', 'Burung peliharaan memiliki berbagai perilaku unik. Pelajari perilaku burung peliharaan Anda untuk memahami kebutuhan dan kebahagiaannya.', 'https://pergiyuk.com/wp-content/uploads/2022/05/Bali-Bird-Park1.jpg', 5),
(6, 'Choosing the Right Fish for Your Aquarium', 'Memilih ikan untuk akuarium Anda adalah langkah penting. Pelajari tentang berbagai jenis ikan dan pertimbangkan faktor-faktor seperti ukuran, suhu air, dan perilaku.', 'https://static.republika.co.id/uploads/images/inpicture_slide/ikan-hiu-_140504174756-289.jpg', 1),
(7, 'Grooming Tips for Your Pet Dog', 'Merawat bulu dan kesehatan kulit anjing Anda penting untuk kesejahteraannya. Ikuti tips grooming ini untuk menjaga anjing Anda tetap sehat dan bersih.', 'https://www.thesprucepets.com/thmb/SV1nJpvIHP0bgP0JkD8GUFgMeZ8=/3600x0/filters:no_upscale():strip_icc()/white-dog-breeds-4846529-hero-4bf084c93c5b45a292e30559bb7e50e8.jpg', 2),
(8, 'Creating the Perfect Habitat for Your Pet Rep', 'Memahami kebutuhan lingkungan hidup reptil peliharaan Anda penting untuk kesejahteraannya. Ikuti panduan ini untuk membuat habitat yang sempurna untuk reptil Anda.', 'https://www.alodokter.com/wp-content/uploads/2021/05/Seputar-Ophidiophobia-Fobia-terhadap-Ular.jpg', 3),
(9, 'Caring for Exotic Pets: Things to Consider', 'Hewan peliharaan eksotis membutuhkan perawatan khusus. Sebelum memutuskan untuk memelihara hewan eksotis, pertimbangkan faktor-faktor seperti ruang, makanan, dan kesehatan.', 'https://www.greeners.co/wp-content/uploads/2021/03/Kucing-Domestik-1.jpg', 4),
(10, 'Keeping Your Pet Happy and Healthy', 'Kesejahteraan hewan peliharaan Anda adalah tanggung jawab Anda sebagai pemilik. Pelajari tentang kebutuhan fisik, mental, dan sosial hewan peliharaan Anda untuk menjaga kebahagiaannya.', 'https://cdn.pixabay.com/photo/2016/02/10/16/37/cat-1192026_1280.jpg', 5);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `nama_depan` varchar(45) NOT NULL,
  `nama_belakang` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `nama_depan`, `nama_belakang`, `email`, `username`, `password`) VALUES
(1, 'rich', 'sutanto', 'richsutanto@gmail.com', 'richsutanto12345', '12345'),
(2, 'John', 'doe', 'johndoe@gmail.com', 'johndoe12345', '1234567'),
(3, 'jessy', 'velin', 'jessyvelin@gmail.com', 'jessyvelin12345', '12345'),
(4, 'heri', 'derry', 'heriderry@gmail.com', 'heriderry12345', '12345'),
(5, 'chelsea', 'daisy', 'chelseadaisy@gmail.com', 'chelseadaisy12345', '12345'),
(6, 'Samuel', 'Tungky', 'samueltungky12345@gmail.com', 'samueltungky12345', '12345'),
(7, 'ariana', 'grande', 'arianagrande@gmail.com', 'arianagrande12345', '12345'),
(8, 'bruno', 'mars', 'brunomars@gmail.com', 'brunomars', '12345'),
(9, 'anjas', 'mara', 'anjasmara@gmail.com', 'anjasmara', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_articles_beritas1_idx` (`beritas_id`);

--
-- Indexes for table `beritas`
--
ALTER TABLE `beritas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_beritas_users_idx` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `beritas`
--
ALTER TABLE `beritas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `fk_articles_beritas1` FOREIGN KEY (`beritas_id`) REFERENCES `beritas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `beritas`
--
ALTER TABLE `beritas`
  ADD CONSTRAINT `fk_beritas_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
