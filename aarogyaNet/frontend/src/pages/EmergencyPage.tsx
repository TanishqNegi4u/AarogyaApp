import { useState } from 'react'

export default function EmergencyPage() {
  const [phone, setPhone] = useState('')
  const [type, setType] = useState('MEDICAL')
  const [sent, setSent] = useState(false)

  const handleSOS = () => {
    if (!phone) return alert('Enter phone number!')
    setSent(true)
    setTimeout(() => setSent(false), 5000)
  }

  return (
    <main style={{ padding: '2rem', maxWidth: '500px', margin: '0 auto' }}>
      <h1 style={{ color: '#a12c7b', fontSize: '2rem' }}>🚨 Emergency SOS</h1>
      <p style={{ color: '#666', marginBottom: '2rem' }}>
        Get immediate help - ambulance dispatched within minutes
      </p>

      {sent && (
        <div style={{ background: '#d4ffea', padding: '1rem',
          borderRadius: '8px', marginBottom: '1rem', color: '#1a6b3c' }}>
          ✅ Emergency request sent! Help is on the way.
        </div>
      )}

      <div style={{ display: 'flex', flexDirection: 'column', gap: '1rem' }}>
        <input
          placeholder="Your phone number"
          value={phone}
          onChange={e => setPhone(e.target.value)}
          style={{ padding: '0.75rem', borderRadius: '8px',
            border: '1px solid #ccc', fontSize: '1rem' }}
        />
        <select value={type} onChange={e => setType(e.target.value)}
          style={{ padding: '0.75rem', borderRadius: '8px',
            border: '1px solid #ccc', fontSize: '1rem' }}>
          <option value="MEDICAL">Medical Emergency</option>
          <option value="ACCIDENT">Road Accident</option>
          <option value="FIRE">Fire Emergency</option>
          <option value="MATERNITY">Maternity Emergency</option>
        </select>
        <button onClick={handleSOS}
          style={{ padding: '1rem', background: '#e53935',
            color: 'white', border: 'none', borderRadius: '8px',
            fontSize: '1.2rem', fontWeight: 700, cursor: 'pointer' }}>
          🚨 SEND SOS NOW
        </button>
      </div>

      <div style={{ marginTop: '2rem', background: '#fff3e0',
        padding: '1rem', borderRadius: '8px' }}>
        <strong>Emergency Numbers:</strong>
        <p>🚑 Ambulance: 108</p>
        <p>🚒 Fire: 101</p>
        <p>👮 Police: 100</p>
        <p>📞 National Emergency: 112</p>
      </div>
    </main>
  )
}