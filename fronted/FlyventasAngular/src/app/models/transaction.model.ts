import { Product } from "./product.model";
import { User } from "./user.model";

export interface Transaction {
    id?: number;
    date: Date;
    price: number;
    product: Product;
    buyer: User;
    seller: User;
}