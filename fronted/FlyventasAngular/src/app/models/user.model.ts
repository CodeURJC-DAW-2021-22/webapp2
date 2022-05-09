import {Category} from "./category.model";
import { Product } from "./product.model";

export interface User {
    id?: number;
    name: string;
    surname: string;
    email: string;
    address: string;
    roles: string[];
    encodedPassword:string;
    categoria1: string;
    categoria2: string;
    categoria3: string;
    products: Product[];
}
