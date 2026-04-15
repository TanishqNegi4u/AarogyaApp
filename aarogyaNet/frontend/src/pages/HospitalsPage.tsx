const hospitals = [
  { name: 'Muzaffarnagar District Hospital', type: 'DISTRICT',
    beds: 200, available: 45, icu: true, ambulance: true, open24: true },
  { name: 'PHC Budhana', type: 'PHC',
    beds: 30, available: 12, icu: false, ambulance: true, open24: false },
  { name: 'AIIMS Delhi', type: 'AIIMS',
    beds: 2000, available: 230, icu: true, ambulance: true, open24: true },
]

export default function HospitalsPage() {
  return (
    <main style={{ padding: '2rem', maxWidth: '800px', margin: '0 auto' }}>
      <h1 style={{ color: '#01696f', fontSize: '2rem' }}>🏥 Hospitals</h1>
      <p style={{ color: '#666', marginBottom: '2rem' }}>
        Find hospitals and health centers near you
      </p>

      {hospitals.map((h, i) => (
        <div key={i} style={{ padding: '1.5rem', background: '#f9f8f5',
          borderRadius: '12px', marginBottom: '1.5rem',
          border: '1px solid #dcd9d5' }}>
          <div style={{ display: 'flex', justifyContent: 'space-between' }}>
            <h2 style={{ color: '#222' }}>{h.name}</h2>
            <span style={{ padding: '0.25rem 0.75rem', background: '#cedcd8',
              borderRadius: '999px', fontSize: '0.8rem', color: '#01696f' }}>
              {h.type}
            </span>
          </div>
          <div style={{ display: 'flex', gap: '1.5rem',
            marginTop: '1rem', flexWrap: 'wrap' }}>
            <span>🛏️ {h.available}/{h.beds} beds</span>
            {h.icu && <span>🏥 ICU Available</span>}
            {h.ambulance && <span>🚑 Ambulance</span>}
            {h.open24 && <span>🕐 24x7 Open</span>}
          </div>
        </div>
      ))}
    </main>
  )
}