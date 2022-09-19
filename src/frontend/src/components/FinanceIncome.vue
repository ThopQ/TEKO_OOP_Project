<script setup lang="ts">
import { onMounted } from "vue";
import { storeToRefs } from "pinia";
import { useFinanceStore } from "../stores/finance";
import FinanceCard from "@/components/FinanceCard.vue";
import FinanceTable from "@/components/FinanceTable.vue";

const finance = useFinanceStore();
const { incomes } = storeToRefs(finance);

onMounted(() => {
  finance.fetchIncomes();
});
</script>

<template>
  <FinanceCard>
    <template #toolbar>
      <div class="badge badge-accent">
        <span class="font-bold text-neutral-content">
          CHF {{ finance.totalIncomes.toFixed(2) }}.-
        </span>
      </div>
    </template>

    <template #title>Income</template>

    <template #body>
      <FinanceTable
        :entries="incomes"
        @add-entry="(income: any) => finance.addIncome(income)"
        @remove-entry="(income: any) => finance.removeIncome(income)"
      ></FinanceTable>
    </template>
  </FinanceCard>
</template>
