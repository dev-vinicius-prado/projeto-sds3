import axios from 'axios'
import { useEffect, useState } from 'react'
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/sale'
import { BASE_URL } from 'utils/requests'
type ChartData = {
  series: number[]
  labels: string[]
}

export const DonutChart = () => {
  const [chartData, setChartData] = useState<ChartData>({
    labels: [],
    series: [],
  })

  useEffect(() => {
    axios
      .get(`${BASE_URL}/sales/amount-by-seller`)
      .then((response) => {
        const data = response.data as SaleSum[]
        const labels = data.map((s) => s.sellerName)
        const series = data.map((s) => s.sum)
        setChartData({ labels, series })
      })
      .catch((err) => console.error(err))
  }, [setChartData])

  const options = {
    legend: {
      show: true,
    },
  }
  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type='donut'
      height='240px'
    />
  )
}
