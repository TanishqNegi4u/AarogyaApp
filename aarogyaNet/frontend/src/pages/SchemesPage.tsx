const schemes = [
  {
    name: 'Ayushman Bharat - PMJAY',
    hindi: 'आयुष्मान भारत',
    benefit: '₹5 lakh health cover per year',
    eligible: 'BPL families',
    url: 'https://pmjay.gov.in'
  },
  {
    name: 'Janani Suraksha Yojana',
    hindi: 'जननी सुरक्षा योजना',
    benefit: '₹1400 cash for hospital delivery',
    eligible: 'Pregnant women (BPL)',
    url: 'https://nhm.gov.in'
  },
  {
    name: 'PM Suraksha Bima Yojana',
    hindi: 'प्रधानमंत्री सुरक्षा बीमा',
    benefit: '₹2 lakh accident insurance at ₹20/year',
    eligible: 'Age 18-70',
    url: 'https://jansuraksha.gov.in'
  },
]

export default function SchemesPage() {
  return (
    <main style={{ padding: '2rem', maxWidth: '800px', margin: '0 auto' }}>
      <h1 style={{ color: '#01696f', fontSize: '2rem' }}>
        📋 Government He