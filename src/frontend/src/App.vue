<script setup lang="ts">
import FinanceOverview from "@/components/FinanceOverview.vue";
import FinanceIncome from "@/components/FinanceIncome.vue";
import FinanceExpenses from "@/components/FinanceExpenses.vue";
import FinanceLoader from "@/components/FinanceLoader.vue";
</script>

<template>
  <FinanceLoader></FinanceLoader>

  <div class="grid min-h-screen w-full place-content-center py-32">
    <div class="fixed top-0 navbar bg-neutral text-neutral-content z-40">
      <a class="btn btn-ghost normal-case text-xl">Finance Overview</a>
    </div>

    <div
      class="grid grid-cols-1 lg:grid-cols-2 gap-4 w-full sm:w-96 md:w-128 lg:w-256"
    >
      <FinanceOverview></FinanceOverview>
      <FinanceIncome></FinanceIncome>
      <FinanceExpenses></FinanceExpenses>
    </div>
  </div>
</template>
