<script setup lang="ts">
import { onMounted } from "vue";
import { storeToRefs } from "pinia";
import { useFinanceStore } from "../stores/finance";
import FinanceCard from "@/components/FinanceCard.vue";
import FinanceTable from "@/components/FinanceTable.vue";

const finance = useFinanceStore();
const { expenses } = storeToRefs(finance);

onMounted(() => {
  finance.fetchExpenses();
});
</script>

<template>
  <FinanceCard>
    <template #toolbar>
      <div class="badge badge-secondary">
        <span class="font-bold text-neutral-content">
          CHF {{ finance.totalExpenses.toFixed(2) }}.-
        </span>
      </div>
    </template>

    <template #title>Expenses</template>

    <template #body>
      <FinanceTable
        :entries="expenses"
        @add-entry="(expense: any) => finance.addExpense(expense)"
        @remove-entry="(expense: any) => finance.removeExpense(expense)"
      ></FinanceTable>
    </template>
  </FinanceCard>
</template>
