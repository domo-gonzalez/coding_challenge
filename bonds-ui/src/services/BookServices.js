import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findBook = () => {
  const book = axios.get(`${hostNameUrl}/book`);
  return book;
};