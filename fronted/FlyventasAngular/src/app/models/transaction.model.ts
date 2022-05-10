import { Product } from "./product.model";
import { User } from "./user.model";

export interface Transaction {
    id?: number;
    date: String;
    price: number;
    product_id: {id?: number,title:string,description: string, category: string, price: number, isSold: boolean, image: boolean,user?: User;};
    seller_id?: { id?: number; name: string; surname: string; email: string; address: string; roles: string[]; encodedPassword:string; categoria1: string; categoria2: string; categoria3: string; products: Product[] };
    buyer_id?: { id?: number; name: string; surname: string; email: string; address: string; roles: string[]; encodedPassword:string; categoria1: string; categoria2: string; categoria3: string; products: Product[] };
}
