package es.codeurjc.Flyventas.controller;

public class ProductRestController {

    /*
    @RequestMapping("/busqueda")
	 public String search(Model model, @RequestParam String title) {

		 List<Product> Product = productServices.findByTitle(title, PageRequest.of(0,9));
		 model.addAttribute("search", title);
		 if (!Product.isEmpty()) {
			 model.addAttribute("Results", Product.size());
			 model.addAttribute("Product", Product);
			 return "search";
		 } else {
			 return "searchnotfound";
		 }
	 }

	@RequestMapping("/category/{category}")
	public String CategorySearch(Model model, @PathVariable String category) {

		List<Product> Product = productServices.findProductByCategoryPageable(category, PageRequest.of(0,9));
		model.addAttribute("search", category);
		if (!Product.isEmpty()) {
			model.addAttribute("Results", Product.size());
			model.addAttribute("Product", Product);
			return "search";
		} else {
			return "/searchnotfound";
		}
	}

	@GetMapping("/Producto/{id}")
	public String showProduct(Model model, @PathVariable long id) {

		Optional<Product> Product = productServices.findById(id);
		if (Product.isPresent()) {

			model.addAttribute("Product", Product.get());
			model.addAttribute("Seller", Product.get().getUser());
			return "Product";
		} else {

			return "searchnotfound";
		}

	}

	@GetMapping("/Producto/{id}/image")
	public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {

		Optional<Product> product = productServices.findById(id);
		if (product.isPresent() && product.get().getImageFile() != null) {

			Resource file = new InputStreamResource(product.get().getImageFile().getBinaryStream());
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").contentLength(product.get().getImageFile().length()).body(file);
		} else {

			return ResponseEntity.notFound().build();
		}
	}
*/

}
