import axios from "axios";

const url = "";

export const fetchTrades = () => {
    axios.get(url);
}

export const fetchTradesById = (id) => {
    axios.get(`${url}/${id}`);
}

export const fetchTradesBySecurity = (secuirtyId) => {
    axios.get(`${url}/${secuirtyId}`);
}

export const createTrade = (newTrade) => {
    axios.post(url, newTrade);
}

export const updateTrade = (id, updatedTrade) => {
    axios.patch(`${url}/${id}`, updatedTrade);
}