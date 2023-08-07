import axios from "axios";

const url = "";

export const fetchSecurites = () => {
    axios.get(url);
}

export const fetchSecuritesById = (id) => {
    axios.get(`${url}/${id}`);
}

export const createSecurity = (newSecurity) => {
    axios.post(url, newSecurity);
}

export const updateSecurity = (id, updatedSecurity) => {
    axios.patch(`${url}/${id}`, updatedSecurity);
}

export const deleteSecurity = (id) => {
    axios.delete(`${url}/${id}`);
}