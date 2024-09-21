-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 02, 2024 lúc 11:54 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlvemaybay`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoso`
--

CREATE TABLE `hoso` (
  `cccd` varchar(12) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `gioitinh` varchar(3) NOT NULL,
  `ngaysinh` varchar(10) NOT NULL,
  `diachi` varchar(40) NOT NULL,
  `sdt` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoso`
--

INSERT INTO `hoso` (`cccd`, `hoten`, `gioitinh`, `ngaysinh`, `diachi`, `sdt`, `email`) VALUES
('021023284772', 'Phạm Minh Thắng', 'Nam', '2003-11-23', 'Hà Nội', '0913312412', 'minhthang@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qlchuyenbay`
--

CREATE TABLE `qlchuyenbay` (
  `macb` varchar(10) NOT NULL,
  `matb` varchar(10) NOT NULL,
  `ngaybay` date NOT NULL,
  `thoigianbay` time(6) NOT NULL,
  `soghe` varchar(10) NOT NULL,
  `machitietcb` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `qlchuyenbay`
--

INSERT INTO `qlchuyenbay` (`macb`, `matb`, `ngaybay`, `thoigianbay`, `soghe`, `machitietcb`) VALUES
('C01', 'D01', '2024-05-01', '18:10:00.000000', 'E01', 'CB1'),
('C02', 'D02', '2024-05-02', '14:05:00.000000', 'E02', 'CB2'),
('C03', 'D03', '2024-05-03', '07:00:00.000000', 'E03', 'CB3'),
('C04', 'D04', '2024-05-04', '21:00:00.000000', 'E04', 'CB4'),
('C05', 'D05', '2024-05-05', '22:00:00.000000', 'E05', 'CB5'),
('C06', 'D06', '2024-05-01', '18:10:00.000000', 'E00', 'CB6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qlkhachhang`
--

CREATE TABLE `qlkhachhang` (
  `makh` varchar(10) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `socccd` varchar(12) NOT NULL,
  `sdt` varchar(10) NOT NULL,
  `gioitinh` varchar(3) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `qlkhachhang`
--

INSERT INTO `qlkhachhang` (`makh`, `hoten`, `socccd`, `sdt`, `gioitinh`, `email`) VALUES
('A01', 'Phạm Minh Thắng', '028021875412', '0974214215', 'Nam', 'minhthang@gmail.com'),
('A02', 'Nguyễn Văn Quyền', '038012456712', '0367549172', 'Nam', 'nguyenquyen@gmail.com'),
('A03', 'Hoàng Anh Tú', '0880734618', '0842168291', 'Nam', 'anhtu@gmail.com'),
('A04', 'Lê Kiều Trang', '462341', '0987578221', 'Nữ', 'kieutrang@gmail.com'),
('A05', 'Vũ Như Nguyệt', '012874572918', '0336710982', 'Nữ', 'nhunguyet@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `qlsanbay`
--

CREATE TABLE `qlsanbay` (
  `Masb` varchar(9) NOT NULL,
  `Tensb` varchar(50) NOT NULL,
  `Tinhthanh` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `qlsanbay`
--

INSERT INTO `qlsanbay` (`Masb`, `Tensb`, `Tinhthanh`) VALUES
('B01', 'Sân Bay Nội Bài', 'Hà Nội'),
('B02', 'Sân Bay Tân Sơn Nhất', 'TP Hồ Chí Minh'),
('B03', 'Sân Bay Thọ Xuân', 'Thanh Hóa'),
('B04', 'Sân Bay Phù Cát', 'Bình Định'),
('B05', 'Sân Bay Côn Đảo', 'Vũng Tàu'),
('B06', 'Sân Bay Huế', 'Thừa Thiên Huế'),
('B07', 'Sân Bay Đà Nẵng', 'Đà Nẵng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tchoadon`
--

CREATE TABLE `tchoadon` (
  `mahd` varchar(15) NOT NULL,
  `mave` varchar(15) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `cccd` varchar(20) NOT NULL,
  `macb` varchar(15) NOT NULL,
  `tongtien` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tchoadon`
--

INSERT INTO `tchoadon` (`mahd`, `mave`, `hoten`, `cccd`, `macb`, `tongtien`) VALUES
('HD1', 'VE3', 'Nguyễn Văn Quyền', '1231', 'C02', 220000),
('HD2', 'VE33', 'Hoàng Anh Tú', '021023284772', 'C02', 110000),
('HD3', 'VE31', 'Nguyễn Văn Quyền', '1231', 'C01', 550000),
('HD5', 'VE35', 'Phạm Minh Thắng', '021023284772', 'C01', 330000),
('VE4', 'VE34', 'Hoàng Anh Tú', '021023284772', 'C01', 330000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tuyenbay`
--

CREATE TABLE `tuyenbay` (
  `Matb` varchar(10) NOT NULL,
  `Masbdi` varchar(10) NOT NULL,
  `Noikh` varchar(50) NOT NULL,
  `Sanbd` varchar(50) NOT NULL,
  `Masbden` varchar(10) NOT NULL,
  `Diemden` varchar(50) NOT NULL,
  `Sanden` varchar(50) NOT NULL,
  `Chieudai` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tuyenbay`
--

INSERT INTO `tuyenbay` (`Matb`, `Masbdi`, `Noikh`, `Sanbd`, `Masbden`, `Diemden`, `Sanden`, `Chieudai`) VALUES
('D01', 'B01', 'Hà Nội', 'Sân Bay Nội Bài', 'B02', 'TP Hồ Chí Minh', 'Sân Bay Tân Sơn Nhất', '2166km'),
('D02', 'B02', 'TP Hồ Chí Minh', 'Sân Bay Tân Sơn Nhất', 'B01', 'Hà Nội', 'Sân Bay Nội Bài', '2166km'),
('D03', 'B05', 'Vũng Tàu', 'Sân Bay Côn Đảo', 'B07', 'Đà Nẵng', 'Sân Bay Đà Nẵng', '1473km'),
('D04', 'B07', 'Nghệ An', 'Sân Bay Vinh', 'B01', 'Hà Nội', 'Sân Bay Nội Bài', '2387km'),
('D05', 'B03', 'Thanh Hóa', 'Sân Bay Thọ Xuân', 'B01', 'Hà Nội', 'Sân Bay Nội Bài', '200km'),
('D06', 'B07', 'Đà Nẵng', 'Sân Bay Đà Nẵng', 'B01', 'Hà Nội', 'Sân Bay Nội Bài', '1158km'),
('D08', 'B03', 'Thanh Hóa', 'Sân Bay Thọ Xuân', 'B05', 'Vũng Tàu', 'Sân Bay Côn Đảo', '100km');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vecuatoi`
--

CREATE TABLE `vecuatoi` (
  `mave` varchar(10) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `cccd` varchar(12) NOT NULL,
  `macb` varchar(10) NOT NULL,
  `soghe` varchar(10) NOT NULL,
  `hangghe` varchar(10) NOT NULL,
  `giave` double NOT NULL,
  `thue` double NOT NULL,
  `tongtien` double NOT NULL,
  `trangthai` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `vecuatoi`
--

INSERT INTO `vecuatoi` (`mave`, `hoten`, `cccd`, `macb`, `soghe`, `hangghe`, `giave`, `thue`, `tongtien`, `trangthai`) VALUES
('VE3', 'Nguyễn Văn Quyền', '1231', 'C02', 'B4', 'Hạng B', 200000, 20000, 220000, 'Đã thanh toán'),
('VE31', 'Nguyễn Văn Quyền', '1231', 'C01', 'E6', 'Hạng E', 500000, 50000, 550000, 'Đã thanh toán'),
('VE33', 'Hoàng Anh Tú', '021023284772', 'C02', 'A5', 'Hạng A', 100000, 10000, 110000, 'Đã thanh toán'),
('VE34', 'Hoàng Anh Tú', '021023284772', 'C01', 'C3', 'Hạng C', 300000, 30000, 330000, 'Đã thanh toán'),
('VE35', 'Phạm Minh Thắng', '021023284772', 'C01', 'C5', 'Hạng C', 300000, 30000, 330000, 'Đã thanh toán');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `hoso`
--
ALTER TABLE `hoso`
  ADD PRIMARY KEY (`cccd`);

--
-- Chỉ mục cho bảng `qlchuyenbay`
--
ALTER TABLE `qlchuyenbay`
  ADD PRIMARY KEY (`macb`),
  ADD KEY `matb` (`matb`);

--
-- Chỉ mục cho bảng `qlkhachhang`
--
ALTER TABLE `qlkhachhang`
  ADD PRIMARY KEY (`makh`),
  ADD KEY `socccd` (`socccd`);

--
-- Chỉ mục cho bảng `qlsanbay`
--
ALTER TABLE `qlsanbay`
  ADD PRIMARY KEY (`Masb`);

--
-- Chỉ mục cho bảng `tchoadon`
--
ALTER TABLE `tchoadon`
  ADD PRIMARY KEY (`mahd`),
  ADD KEY `mave` (`mave`),
  ADD KEY `macb` (`macb`);

--
-- Chỉ mục cho bảng `tuyenbay`
--
ALTER TABLE `tuyenbay`
  ADD PRIMARY KEY (`Matb`),
  ADD KEY `Masbdi` (`Masbdi`),
  ADD KEY `Masbden` (`Masbden`);

--
-- Chỉ mục cho bảng `vecuatoi`
--
ALTER TABLE `vecuatoi`
  ADD PRIMARY KEY (`mave`),
  ADD KEY `macb` (`macb`),
  ADD KEY `cccd` (`cccd`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `qlchuyenbay`
--
ALTER TABLE `qlchuyenbay`
  ADD CONSTRAINT `qlchuyenbay_ibfk_1` FOREIGN KEY (`matb`) REFERENCES `tuyenbay` (`Matb`);

--
-- Các ràng buộc cho bảng `tchoadon`
--
ALTER TABLE `tchoadon`
  ADD CONSTRAINT `tchoadon_ibfk_1` FOREIGN KEY (`mave`) REFERENCES `vecuatoi` (`mave`),
  ADD CONSTRAINT `tchoadon_ibfk_2` FOREIGN KEY (`macb`) REFERENCES `qlchuyenbay` (`macb`);

--
-- Các ràng buộc cho bảng `tuyenbay`
--
ALTER TABLE `tuyenbay`
  ADD CONSTRAINT `tuyenbay_ibfk_1` FOREIGN KEY (`Masbdi`) REFERENCES `qlsanbay` (`Masb`),
  ADD CONSTRAINT `tuyenbay_ibfk_2` FOREIGN KEY (`Masbden`) REFERENCES `qlsanbay` (`Masb`);

--
-- Các ràng buộc cho bảng `vecuatoi`
--
ALTER TABLE `vecuatoi`
  ADD CONSTRAINT `vecuatoi_ibfk_1` FOREIGN KEY (`macb`) REFERENCES `qlchuyenbay` (`macb`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
