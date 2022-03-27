package es.codeurjc.Flyventas.controller;

public class TransactionRestController {

    /*@GetMapping("/confirmacionCompra/{id}")
	public String comfirmTransaction(Model model, @PathVariable long id) {

		Optional<Product> Product = productServices.findById(id);
		if (Product.isPresent()) {
			model.addAttribute("Product", Product.get());
			return "purchase";
		} else {
			return "searchnotfound";
		}
	}

	@GetMapping("/resumen/{id}/{tokenpayment}")
	public String newTransaction(Model model, HttpServletRequest request, @PathVariable long id, @PathVariable String tokenpayment) {

		Principal principal = request.getUserPrincipal();
		Optional<Product> Product = productServices.findById(id);

		//Before making the transaction, it would be necessary to check if the token that you have sent us through the link is the same as the one that the payment gateway sends us.
		if (Product.isPresent()) {

			Optional<User> User = userServices.findUserByEmail(principal.getName());
			transactions.save(new Transaction(Product.get(), User.get(), Product.get().getPrice()));


			model.addAttribute("Product", Product.get());

			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(principal.getName());
			email.setSubject("Recibo FlyVentas");
			String str = Long.toString(id);
			String message = ("https://localhost:8443/resumen/"+str+"/12345/?format=pdf");
			email.setText(message);
			mailSender.send(email);
			return "resumen";
} else {

        return "searchnotfound";
        }
        }*/
}
