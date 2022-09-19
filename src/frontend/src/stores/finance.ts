import { defineStore } from "pinia";
import axios from "axios";
import Entry from "../models/Entry";

export const useFinanceStore = defineStore("finance", {
  state: () => {
    return {
      incomes: [] as Entry[],
      expenses: [] as Entry[],

      incomeIsLoading: true as Boolean,
      expenseIsLoading: true as Boolean,
    };
  },

  getters: {
    totalIncomes(state): number {
      return state.incomes.reduce((accumulator, entry: Entry) => {
        return accumulator + entry.amount;
      }, 0);
    },

    totalExpenses(state): number {
      return state.expenses.reduce((accumulator, entry: Entry) => {
        return accumulator + entry.amount;
      }, 0);
    },

    totalRevenue(): number {
      return this.totalIncomes - this.totalExpenses;
    },

    isLoading(state): Boolean {
      return state.incomeIsLoading || state.expenseIsLoading;
    },

    isNice(): Boolean {
      return this.totalRevenue === 69;
    },
  },

  actions: {
    async fetchIncomes() {
      await axios
        .get<Entry[]>("/api/incomes/")
        .then((response) => {
          this.incomes = response.data;
        })
        .finally(() => (this.incomeIsLoading = false));
    },

    async fetchExpenses() {
      await axios
        .get<Entry[]>("/api/expenses/")
        .then((response) => {
          this.expenses = response.data;
        })
        .finally(() => (this.expenseIsLoading = false));
    },

    async addIncome(income: Entry) {
      await axios.post("/api/incomes/", income).then((response) => {
        this.incomes.unshift(response.data);
      });
    },

    async addExpense(expense: Entry) {
      await axios
        .post("/api/expenses/", expense)
        .then((response: { data: Entry }) => {
          this.expenses.unshift(response.data);
        });
    },

    async removeIncome(income: Entry) {
      await axios.delete(`/api/incomes/${income.id}`).then(() => {
        this.incomes = this.incomes.filter(
          (entry: Entry) => entry.id !== income.id
        );
      });
    },

    async removeExpense(expense: Entry) {
      await axios.delete(`/api/expenses/${expense.id}`).then(() => {
        this.expenses = this.expenses.filter(
          (entry: Entry) => entry.id !== expense.id
        );
      });
    },
  },
});
