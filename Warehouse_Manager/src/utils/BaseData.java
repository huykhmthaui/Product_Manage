package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import objects.Product;

public class BaseData {

	public static Product generateProduct() {
		int index;
		Product product = new Product();
		// Tạo danh sách tên sản phẩm
		String[] productNames = { "IPhone 6", "IPhone 6s", "IPhone 7", "IPhone 7 Plus", "IPhone 8", "IPhone 8 Plus",
				"IPhone X", "IPhone XS", "IPhone XS Max", "IPhone 11", "IPhone 11 Pro", "IPhone 11 Pro Max",
				"IPhone 12 Mini", "IPhone 12 Pro", "IPhone 12 Pro Max", "IPhone 13 Mini", "IPhone 13 Pro",
				"IPhone 13 Pro Max", "SamSung Galaxy A33", "SamSung Galaxy A53", "SamSung Galay A13",
				"SamSung Galaxy A23", "SamSung Galaxy S22", "SamSung Galaxy S21", "SamSung Galaxy A03" };

		// random id sản phẩm
		product.setProduct_id(String.valueOf((int)(Math.random() * 1000)));

		// random tên sản phẩm
		index = (int) (Math.random() * productNames.length);
		product.setProduct_name(productNames[index]);

		// random giá sản phẩm
		index = (int) (Math.random() * 1000) + 800;
		product.setProduct_price(index);

		// random số lượng sản phẩm
		index = (int) (Math.random() * 100) + 5;
		product.setProduct_total(index);
		
		// chắc chắn rằng năm sản xuất bé hơn hoặc bằng hạn sử dụng, năm nhập lớn hoặc hoặc
		// bằng năm sản xuất
		
		int index1, index2, index3;
		
		do {
			// random năm sản xuất
			index1 = (int) (Math.random() * 3) + 2019;
			// random hạn sử dụng
			index2 = (int) (Math.random() * 3) + 2019;
			// random năm nhập sản phẩm
			index3 = (int) (Math.random() * 3) + 2019;
		}while(index1 > index2 || index3 < index1);
		
		product.setProduct_exp(index1);
		product.setProduct_mfg(index2);
		product.setProduct_addtime(index3);
		return product;
	}

	/**
	 * This method is used to generate Product list.<br>
	 * 
	 * @param count
	 * @return
	 */
	public static List<Product> generateProducts(int count) {
		// Tạo mảng lưu dữ liệu
		List<Product> productList = new ArrayList<>(count);

		for (int i = 0; i < count; i++) {
			// Sinh ngẫu nhiên một sản phẩm
			// Thêm sản phẩm vào danh sách
			productList.add(generateProduct());
		}
		// Trả về kết quả
		return productList;
	}

	/**
	 * This method is used to read product list from file.<br>
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static List<Product> productInputStream() throws IOException, ClassNotFoundException {
		// Khai báo biến danh sách sản phẩm
		List<Product> productList = new ArrayList<Product>();
		// Khai báo đối tượng file
		File file = new File("Product.bin");
		// Kiểm tra file đã tồn tại
		if (file.exists()) {
			// Xác định đối tượng tập tin xuất dữ liệu
			FileInputStream inFile = new FileInputStream("Product.bin");
			// Khai báo đối tượng thực hiện xuất
			ObjectInputStream in = new ObjectInputStream(inFile);
			// Đọc kích thước danh sách
			int size = in.readInt();
			// Duyệt theo kích thước để đọc thông tin
			for (int index = 0; index < size; index++) {
				// Đọc đối tượng và lưu vào danh sách
				productList.add((Product) in.readObject());
			}
			// đóng file đang đọc
			in.close();
		} else {
			productList = generateProducts(10);
			productOutputStream(productList, "Product.bin");
		}
		// Trả kết quả danh sách
		return productList;
	}

	/**
	 * This method is used to write product list to file.<br>
	 */
	public static void productOutputStream(List<Product> list, String fileName) throws IOException {
		// Xác định đối tượng tập tin xuất dữ liệu
		FileOutputStream outFile = new FileOutputStream(fileName);
		// Khai báo đối tượng xuất dữ liệu
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		// In kích thước danh sách lên đầu
		out.writeInt(list.size());

		// Duyệt phần tử trong danh sách
		for (int index = 0; index < list.size(); index++) {
			// Xuất từng phần tử ra file
			out.writeObject(list.get(index));
		}
		// Đóng file sau khi xuất
		out.close();
	}
	
	public static void exportStream(List<Product> list, String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		PrintWriter writer = new PrintWriter(fw);
		writer.println("Tổng số sản phẩm: " + list.size());
		writer.printf("%-10s%-25s%8s%10s%10s%10s%10s\n", "ID", "Tên sản phẩm", "Giá sản phẩm",
				"Số lượng", "Năm sản xuất", "Hạn sử dụng", "Ngày nhập");
		list.forEach(m -> {
			writer.println(m);
		});
		writer.close();
	}
}
