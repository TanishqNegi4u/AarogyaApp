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
        📋 Government Health Schemes
      </h1>
      <p style={{ color: '#666', marginBottom: '2rem' }}>
        सरकारी स्वास्थ्य योजनाएं - Find schemes you are eligible for
      </p>

      {schemes.map((s, i) => (
        <div key={i} style={{ padding: '1.5rem', background: '#f9f8f5',
          borderRadius: '12px', marginBottom: '1.5rem',
          border: '1px solid #dcd9d5' }}>
          <h2 style={{ color: '#222', fontSize: '1.2rem' }}>{s.name}</h2>
          <p style={{ color: '#888', fontSize: '0.9rem' }}>{s.hindi}</p>
          <p style={{ marginTop: '0.5rem' }}>
            <strong>Benefit:</strong> {s.benefit}
          </p>
          <p><strong>Eligible:</strong> {s.eligible}</p>
          <a href={s.url} target="_blank" rel="noopener noreferrer"
            style={{ display: 'inline-block', marginTop: '1rem',
              padding: '0.5rem 1rem', background: '#01696f',
              color: 'white', borderRadius: '6px',
              textDecoration: 'none', fontSize: '0.9rem' }}>
            Apply Now →
          </a>
        </div>
      ))}
    </main>
  )
}